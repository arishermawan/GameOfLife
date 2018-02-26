# Game of Life

This project is implementation of Conway's Game Of Life

The "game" is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input

## Rules

1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
4. Any live cell with more than three live neighbours dies, as if by overpopulation.

## Getting Started

### Prerequisites
First, install jdk8.

**mac os**
```
brew cask install java8
```
**linux**
```
sudo apt-get -y install openjdk-8-jdk wget unzip
```
Once you have java, install gradle.
**mac os**
```
brew install gradle
```
**linux**
```
wget https://services.gradle.org/distributions/gradle-3.4.1-bin.zip
sudo mkdir /opt/gradle
sudo unzip -d /opt/gradle gradle-3.4.1-bin.zip
export PATH=$PATH:/opt/gradle/gradle-3.4.1/bin
```

### Building the app
To build the app, navigate to the project folder, and build:
```
gradle build
```

### Testing the app
To test the app, navigate to the project folder and run the following:
```
gradle test
```
