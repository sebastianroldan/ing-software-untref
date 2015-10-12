#!/usr/bin/env sh
set -e
cd ejercicio1
mvn test
cd ../ejercicio2/cucumber-java-skeleton
mvn test
cd..
cd../ejercicio3
mvn test