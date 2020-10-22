# Gatling-load-tests

## Getting started

1. brew install scala
1. brew install maven
1. install java

## Launch

1. git clone https://github.com/chickentony/gatling-load-tests.git
1. mvn install
1. mvn gatling:test -Dgatling.simulationClass=loadtests.foodservice.Menu

## Settings

All scenarios have default settings atOnceUsers(1) - that means 1 rps

If you need to set rps during some time use (rampUsersPerSec(1.0) to (4.0) during(200))

## TroubleShooting
Если при запуске сценария появляется ошибка вида:

```
Unrecognized VM option 'AggressiveOpts'
Error: Could not create the Java Virtual Machine.
Error: A fatal exception has occurred. Program will exit.
```

нужно проверить версию java используемую при запуске команды mvn сделать это можно написав в терминале, в котором запускается сценарий, команду mvn -v. Ошибка возникает на версиях java выше 11.

Что бы maven использовал корректную версию java, нужно задать значение переменной окружения $JAVA_HOME (предварительно стоит проверить, не установлено ли там значение командой: echo $JAVA_HOME, в терминале, где запускается сценарий) == /Library/Java/JavaVirtualMachines/ваша_версия_java/Contents/Home

Или же отредактировать файл .bashrc задав там константу: export JAVA_HOME=$(/usr/libexec/java_home -v 1.8.0_201)