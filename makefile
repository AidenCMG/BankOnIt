CheckingAccount.class: CheckingAccount.java HasMenu.class
	javac -g CheckingAccount.java


HasMenu.class: HasMenu.java
	javac -g HasMenu.java

testChecking: CheckingAccount.class
	java CheckingAccount

SavingsAccount.class: SavingsAccount.java CheckingAccount.class
	javac -g SavingsAccount.java

testSavings: SavingsAccount.class
	java SavingsAccount

User.class: User.java HasMenu.class
	javac -g User.java

clean:
	rm *.class