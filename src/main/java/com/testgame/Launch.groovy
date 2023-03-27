package com.testgame

def server = new Server()

 println('Start a new game? (Y/N)')

def scanner = new Scanner(System.in)
def choice = scanner.nextLine()

 if (choice.equals("n")) {
  println("Goodbye :(")
  return
 }

println("Pick a username!")
server.launch(scanner.nextLine().toLowerCase())