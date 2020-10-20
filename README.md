# Gatling-load-tests

## Getting started

1. brew install scala
1. brew install maven
1. install java

## Launch

1. git clone https://github.com/chickentony/gatling-load-tests.git
1. mvn install
1. mvn gatling:test -Dgatling.simulationClass=loadtests.Menu

## Settings

All scenarios have default settings atOnceUsers(1) - that means 1 rps

If you need to set rps during some time use (rampUsersPerSec(1.0) to (4.0) during(200))