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

Customer.class: Customer.java SavingsAccount.class User.class
	javac -g Customer.java

Admin.class: Admin.java User.class
	javac -g Admin.java

Bank.class: Bank.java Admin.class Customer.class
	javac -g Bank.java