@echo off
javac -cp "lib;*" src\*.java -d bin
java -cp "bin;lib/*" SignIn