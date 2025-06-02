Compile

Users
javac -cp "lib/mysql-connector-j-9.3.0.jar" src/Users.java -d bin

SignIn
javac -cp "lib/mysql-connector-j-9.3.0.jar" src/SignIn.java -d bin

tous les fichiers: 
javac -cp "lib/mysql-connector-j-9.3.0.jar" src/*.java -d bin

compile .jar et .java :
javac -cp "lib/*" src/*.java -d bin




Execute:

Users
java -cp "bin;lib/mysql-connector-j-9.3.0.jar;lib/jbcrypt-0.4.jar" Users


SignIn
java -cp "bin;lib/mysql-connector-j-9.3.0.jar;lib/jbcrypt-0.4.jar" SignIn


LoggIn
java -cp "bin;lib/mysql-connector-j-9.3.0.jar;lib/jbcrypt-0.4.jar" LoggIn





reboot MySQL :
net stop MySQL80
net start MySQL80
