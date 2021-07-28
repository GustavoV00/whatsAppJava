#!/bin/bash

find . -type f -name "*.class" -delete
javac App.java
java App
