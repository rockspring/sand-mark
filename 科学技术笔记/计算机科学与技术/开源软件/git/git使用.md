# git使用

2017年05月17日

## git status中文件名正常显示

```
git config --global core.quotepath false
```

## 列出忽略的文件

```
git ls-files . --ignored --exclude-standard --others
```

## 列出未跟踪的文件

```
git ls-files . --exclude-standard --others
```

## 是否显示untracted文件

```
git config --global status.showuntrackedfiles no # 不显示
git config --global status.showuntrackedfiles normal # 显示文件夹
git config --global status.showuntrackedfiles all # 显示文件
```

## 将大文件加入到ignore

```
find . -size +10M | cat >> .gitignore

find . -size +1G | cat >> .gitignore
```


# git clean

[git-clean](https://git-scm.com/docs/git-clean)

## 删除git未跟踪的目录和文件

```
git clean -dn # 不删除，仅仅列出要删除的目录和文件
git clean -di # 交互式删除
git clean -df # 强制删除
```

## 删除在.gitignore文件中让git忽略的文件

```
git clean -Xn # 不删除，仅仅列出要删除的目录和文件
git clean -Xi # 交互式删除
git clean -Xf # 强制删除
```

## 删除未跟踪的文件和在.gitignore文件中让git忽略的文件

目录不处理

```
git clean -xn # 不删除，仅仅列出要删除的文件
git clean -xi # 交互式删除
git clean -xf # 强制删除
```

# git reset

## 将多个提交（commit）压缩（squash）成一个提交

```
git reset --soft HEAD~3 && 
git commit --edit -m"$(git log --format=%B --reverse HEAD..HEAD@{1})"
```

## 将已经在暂存区的文件移动至unstage区

```
git reset HEAD
```
