class Account:
    ID = 1
    counter = 0
    def __init__(self, initial_deposit):
        self.balance = initial_deposit
    def withdraw(self, amount):
        for i in range(0, 3):
            check = int(input("What is your account ID? : "))
            if not check == self.ID:
                self.counter += 1
                if self.counter == 3:
                    print("This account is locked. Please call again.")
            else:
                if amount > self.balance:
                    self.counter = 0
                    return 0
                else:
                    self.balance -= amount
                    self.counter = 0
                    return amount
    def deposit(self, amount):
        for i in range(0, 3):
            check = int(input("What is your account ID? : "))
            if not check == self.ID:
                self.counter += 1
                if self.counter == 3:
                    print("This account is locked. Please call again.")
            else:
                self.balance += amount
                return self
    def current_balance(self):
        return self.balance
class Bank(Account):
    def __init__(self, name, initial_deposit):
        self.name = name
        Account.__init__(self, initial_deposit)
        self.ID = Account.ID
        Account.ID += 1
        self.locked_out = False
   
    def get_balamce(self):
        for i in range (0, 3):
            check = int(input("What is your account ID? : "))
            if check == self.ID:
                self.counter = 0
                return "Name:" + self.name + " " + "Balance: " + str(self.balance)
            else:
                self.counter += 1
                if self.counter == 3:
                    print("This account is locked. Please call again.")
                    
            
    def __str__(self):
        return "Name: {0} ID: {1} Balance: {2}".format(self.name, self.ID, self.current_balance())

x1 = Bank("Kaiser", 100)
x2 = Bank("Ursala", 200)
x3 = Bank("Shilah", 75)

print(x3.deposit(2))