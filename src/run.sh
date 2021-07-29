#!/bin/bash

find . -type f -name "*.class" -delete
javac Programa.java
java Programa
