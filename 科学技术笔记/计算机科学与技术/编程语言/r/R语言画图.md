R语言画图

https://stat.ethz.ch/R-manual/R-devel/library/datasets/html/mtcars.html

http://cos.name/wp-content/uploads/2012/05/3-xiaokai-ggplot2.pdf


http://www.linuxeden.com/html/news/20161227/167480.html

https://www.zhihu.com/question/24779017

system("defaults write org.R-project.R force.LANG en_US.UTF-8")
install.packages(c("ggplot2", "cookbook"))


## 1

ggplot(ce, aes(x=Date, y=percent_weight, fill=Cultivar)) + geom_bar(stat="identity") + geom_text(aes(y=label_y,label=percent_weight)) + ggtitle("a")


plot + labs(title = 'Graph Title') + theme(plot.title  = element_text(colour = 'red', angle = 45, size = 10,hjust = 0.5, vjust = 0.5, face = 'bold'))


ggplot(ce, aes(x=Date, y=percent_weight, fill=Cultivar)) + geom_bar(stat="identity") + geom_text(aes(y=label_y,label=percent_weight)) + labs(title="a",subtitle="b", caption = "(based on data from ...)") + theme(plot.title  = element_text(colour = 'black', angle = 0, size = 10,hjust = 0.5, vjust = 0.5, face = 'bold')) + theme(plot.subtitle  = element_text(colour = 'black', angle = 0, size = 10,hjust = 0.5, vjust = 0.5, face = 'plain'))


ggplot(ce, aes(x=Date, y=Weight,label=Weight, fill=Cultivar)) + geom_bar(stat="identity") + geom_text(check_overlap = TRUE)



```
> cabbage_exp
  Cultivar Date Weight        sd  n         se
1      c39  d16   3.18 0.9566144 10 0.30250803
2      c39  d20   2.80 0.2788867 10 0.08819171
3      c39  d21   2.74 0.9834181 10 0.31098410
4      c52  d16   2.26 0.4452215 10 0.14079141
5      c52  d20   3.11 0.7908505 10 0.25008887
6      c52  d21   1.47 0.2110819 10 0.06674995
```

then, it's sorted by Cultivar and Date

```
> cabbage_exp <- arrange(cabbage_exp, Date, as.integer(Cultivar))
> cabbage_exp
  Cultivar Date Weight        sd  n         se
1      c39  d16   3.18 0.9566144 10 0.30250803
2      c52  d16   2.26 0.4452215 10 0.14079141
3      c39  d20   2.80 0.2788867 10 0.08819171
4      c52  d20   3.11 0.7908505 10 0.25008887
5      c39  d21   2.74 0.9834181 10 0.31098410
6      c52  d21   1.47 0.2110819 10 0.06674995
```

then, a graph is drawed

```
> ggplot(ce, aes(x=Date, y=Weight,label=Weight, fill=Cultivar)) + geom_bar(stat="identity") + geom_text(check_overlap = TRUE)
> ggplot(ce, aes(x=Date, y=Weight,label=Weight, fill=Cultivar)) + geom_bar(stat="identity") + geom_text(check_overlap = TRUE,position = position_dodge(0.9))

> ggplot(ce, aes(x=Date, y=Weight,label=Weight, fill=Cultivar)) + geom_bar(stat="identity") + geom_text(check_overlap = TRUE,position = position_stack(0.9))


```

## 2


bmp(filename = "Rplot%03d.bmp",
    width = 480, height = 480, units = "px", pointsize = 12,
    bg = "white", res = NA, ...,
    type = c("cairo", "Xlib", "quartz"), antialias)

jpeg(filename = "Rplot%03d.jpeg",
     width = 480, height = 480, units = "px", pointsize = 12,
     quality = 75,
     bg = "white", res = NA, ...,
     type = c("cairo", "Xlib", "quartz"), antialias)

png(filename = "Rplot%03d.png",
    width = 480, height = 480, units = "px", pointsize = 12,
     bg = "white",  res = NA, ...,
    type = c("cairo", "cairo-png", "Xlib", "quartz"), antialias)

tiff(filename = "Rplot%03d.tiff",
     width = 480, height = 480, units = "px", pointsize = 12,
     compression = c("none", "rle", "lzw", "jpeg", "zip", "lzw+p", "zip+p"),
     bg = "white", res = NA,  ...,
     type = c("cairo", "Xlib", "quartz"), antialias)

> svg(file="example.svg", width=8, height=6)
> p <- ggplot(data=mpg, mapping=aes(x=cty, y=hwy))
> p + geom_point()
> dev.off()

> png(filename="Std_PNG.png", 
+     units="in", 
+     width=5, 
+     height=4, 
+     pointsize=12, 
+     res=72)
> 
> 
> p <- ggplot(data=mpg, mapping=aes(x=cty, y=hwy))
> p + geom_point()
> dev.off()

> jpeg(filename = "Rplot%03d.jpeg",      width = 480, height = 480, units = "px", pointsize = 12,      quality = 75,      bg = "white", res = NA,      type = c("cairo", "Xlib", "quartz"))
> p <- ggplot(data=mpg, mapping=aes(x=cty, y=hwy))
> p + geom_point()
> dev.off()


## 3

package:graphics

绘制折线图

plot(pressure$temperature, pressure$pressure, type="l")

添加一些点
points(pressure$temperature, pressure$pressure)

添加一根线
lines(pressure$temperature, pressure$pressure/2, col="red")

添加一些点
points(pressure$temperature, pressure$pressure/2, col="red")


ggplot2