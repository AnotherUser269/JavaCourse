# Repository overview:

This repository contains 3 small Java console projects. These projects were created as course test assignments.

# Getting started:

1. Clone this repository:

```shell
git clone https://github.com/AnotherUser269/JavaCourse/

cd JavaCourse
```
2. Compile and run by using the instrictions bellow.


# Project 1 - HangMan:

The first project is an implementetion of the hangman game. Uses words of length >= 5 from the https://github.com/first20hours/google-10000-english/ repository. This small programm displays an ascii arts, representing the current game state. 


**Build & run:**
```shell
cd HangMan/

javac -d out src/hangman/HangMan.java
java -cp out hangman.HangMan
```

**To do:**

1) Add menu/screens (restarting, etc...)
2) Find a better solution to clear the console
3) Add a json support for loading states



# Project 2 - Independent States currency converter (ISCConverter):

The second project implements a simple logic of converting currencies. It uses a simple notation, which provides a better user experience.

**Build & run:**
```shell
cd IndependentStatesCurrencyConverter/

javac -d out src/iscconverter/ISCConverter.java
java -cp out iscconverter.ISCConverter
```

**To do:**

1) Add webscrapping or an API client to provide an actuall information


# Project 3 - Strong Password Generator:

Warning, it's a very bad practice, to use a pseudorandom numbers, while creating a security system, so this project is for educational purpouses only. The task was to create a password with 8 <= length <= 12, so there is almost nothing to improve.

**Build & run:**
```shell
cd PasswordGenerator/

javac -d out src/passwordgen/PasswordGenerator.java
java -cp out passwordgen.PasswordGenerator
```

**Later:**
1) Use different algorithms instead of just nextInt
2) Improve the current generating logic
