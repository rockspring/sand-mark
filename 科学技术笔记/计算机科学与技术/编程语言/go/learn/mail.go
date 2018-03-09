package main

import "net/smtp"
import "log"
import "fmt"
import "github.com/jpoehls/gophermail"
import "gopkg.in/gomail.v1"

func a() {
	// Set up authentication information.
	auth := smtp.PlainAuth("", "leqinzhou@anjuke.com", "anjuke4873", "smtp.anjuke.com")

	// Connect to the server, authenticate, set the sender and recipient,
	// and send the email all in one step.
	to := []string{"leqinzhou@anjuke.com"}
	msg := []byte("This is the email body.")
	err := smtp.SendMail("smtp.anjuke.com:25", auth, "leqinzhou@anjuke.com", to, msg)
	if err != nil {
		log.Fatal(err)
	}
}


func b() {
	// Set up authentication information.
	auth := smtp.PlainAuth("", "leqinzhou@anjuke.com", "anjuke4873", "smtp.anjuke.com")

	// Connect to the remote SMTP server.
    c, err := smtp.Dial("smtp.anjuke.com:25")
    if err != nil {
            log.Fatal(err)
    }

    err = c.Auth(auth)

    // Set the sender and recipient first
    if err := c.Mail("leqinzhou@anjuke.com"); err != nil {
            log.Fatal(err)
    }
    if err := c.Rcpt("leqinzhou@anjuke.com"); err != nil {
            log.Fatal(err)
    }

    // Send the email body.
    wc, err := c.Data()
    if err != nil {
            log.Fatal(err)
    }
    _, err = fmt.Fprintf(wc, "subject: 主题\r\n\r\nThis is the email body<p>ab</p>")
    _, err = fmt.Fprintf(wc, "subject: 主题\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"> <html> <head> <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\"> <title>标题</title> </head> <body> <p>HTML体</p> </body> </html>")
    if err != nil {
            log.Fatal(err)
    }
    err = wc.Close()
    if err != nil {
            log.Fatal(err)
    }

    // Send the QUIT command and close the connection.
    err = c.Quit()
    if err != nil {
            log.Fatal(err)
    }
}

func c() {
    message := new(gophermail.Message)
    message.AddTo("leqinzhou@anjuke.com")
    message.SetFrom("leqinzhou@anjuke.com")
    message.HTMLBody = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"> <html> <head> <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\"> <title>标题</title> </head> <body> <p>HTML体</p> </body> </html>"
    // Set up authentication information.
    auth := smtp.PlainAuth("", "leqinzhou@anjuke.com", "anjuke4873", "smtp.anjuke.com")

    gophermail.SendMail("leqinzhou@anjuke.com", auth, message)
}

func d() {
    msg := gomail.NewMessage()
    msg.SetHeader("From", "leqinzhou@anjuke.com")
    msg.SetHeader("To", "leqinzhou@anjuke.com")
    //msg.SetAddressHeader("Cc", "dan@example.com", "Dan")
    msg.SetHeader("Subject", "Hello!")
    msg.SetBody("text/html", "Hello <b>Bob</b> and <i>Cora</i>!")

    /*f, err := gomail.OpenFile("/home/Alex/lolcat.jpg")
    if err != nil {
        panic(err)
    }
    msg.Attach(f)*/

    // Send the email to Bob, Cora and Dan
    mailer := gomail.NewMailer("smtp.anjuke.com", "lqinzhou", "anjuke4873", 25)
    if err := mailer.Send(msg); err != nil {
        panic(err)
    }
}

func main() {
	d()
}