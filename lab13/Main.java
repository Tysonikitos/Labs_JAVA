import java.util.HashMap;
import java.util.Map;

// 1. Исключение: недостаточно средств
class InsufficientFundsException extends Exception {
    private double requested;
    private double balance;

    public InsufficientFundsException(String message, double requested, double balance) {
        super(message);
        this.requested = requested;
        this.balance = balance;
    }

    public double getRequested() {
        return requested;
    }

    public double getBalance() {
        return balance;
    }
}

// 2. Исключение: неверная сумма операции
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

// 3. Исключение: счет не найден
class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

class BankAccount {
    private static final Map<String, BankAccount> registry = new HashMap<>();

    private String accountNumber;
    private String owner;
    private double balance;

    public BankAccount(String accountNumber, String owner, double balance) throws InvalidAmountException {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер счета не может быть null или пустым");
        }
        if (balance < 0) {
            throw new InvalidAmountException("Начальный баланс не может быть отрицательным: " + balance);
        }
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
        registry.put(accountNumber, this);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Сумма пополнения должна быть больше 0 (передано: " + amount + ")");
        }
        balance += amount;
        System.out.println("Счет " + accountNumber + " (" + owner + ") пополнен на " + amount + ". Баланс: " + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Сумма снятия должна быть больше 0 (передано: " + amount + ")");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Недостаточно средств на счете " + accountNumber, amount, balance);
        }
        balance -= amount;
        System.out.println("Со счета " + accountNumber + " (" + owner + ") снято " + amount + ". Баланс: " + balance);
    }

    public void transfer(String target, double amount)
            throws AccountNotFoundException, InsufficientFundsException, InvalidAmountException {
        BankAccount targetAccount = registry.get(target);
        if (targetAccount == null) {
            throw new AccountNotFoundException("Целевой счет '" + target + "' не найден в системе");
        }
        this.withdraw(amount);
        targetAccount.deposit(amount);
        System.out.println("Перевод " + amount + " со счета " + this.accountNumber + " на счет " + target + " выполнен успешно");
    }

    @Override
    public String toString() {
        return "Счет №" + accountNumber + " | Владелец: " + owner + " | Баланс: " + balance;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            // Создание 3 банковских счетов
            BankAccount acc1 = new BankAccount("BY01", "Иван Иванов", 500.0);
            BankAccount acc2 = new BankAccount("BY02", "Анна Петрова", 300.0);
            BankAccount acc3 = new BankAccount("BY03", "Олег Сидоров", 100.0);

            System.out.println("=== Исходное состояние счетов ===");
            System.out.println(acc1);
            System.out.println(acc2);
            System.out.println(acc3);

            System.out.println("\n=== 1. Успешные операции ===");
            acc1.deposit(150.0);
            acc1.transfer("BY02", 200.0);

            System.out.println("\n=== 2. Проверка InvalidAmountException ===");
            try {
                acc2.deposit(-50.0);
            } catch (InvalidAmountException e) {
                System.out.println("Перехвачено исключение: " + e.getMessage());
            }

            System.out.println("\n=== 3. Проверка InsufficientFundsException ===");
            try {
                acc3.withdraw(500.0);
            } catch (InsufficientFundsException e) {
                System.out.println("Перехвачено исключение: " + e.getMessage() +
                        " (Запрошено: " + e.getRequested() + ", Доступно: " + e.getBalance() + ")");
            }

            System.out.println("\n=== 4. Проверка AccountNotFoundException ===");
            try {
                acc1.transfer("BY99", 100.0);
            } catch (AccountNotFoundException e) {
                System.out.println("Перехвачено исключение: " + e.getMessage());
            }

            System.out.println("\n=== 5. Проверка конструктора (номер счета null) ===");
            try {
                new BankAccount(null, "Тест", 100.0);
            } catch (IllegalArgumentException e) {
                System.out.println("Перехвачено исключение конструктора: " + e.getMessage());
            }

            System.out.println("\n=== Итоговое состояние счетов ===");
            System.out.println(acc1);
            System.out.println(acc2);
            System.out.println(acc3);

        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e.getMessage());
        } finally {
            System.out.println("\nРабота банковской системы завершена (блок finally).");
        }
    }
}