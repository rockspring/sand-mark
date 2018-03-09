
setwd("/Users/zlq/Tmp")
float_data <- read.table("float.txt")
p <- ggplot(data=float_data, mapping=aes(x=V5,y=V1))
p <- p + geom_point()
p <- p + ylim(0,255) + xlim(-240,240)
p <- p + geom_hline(aes(yintercept=255), colour="#BB0000", linetype="dashed")
p <- p + geom_hline(aes(yintercept=127), colour="#BB0000", linetype="dashed")
