interface PaymentSystem {
    void pay(double amount);
    void refund(double amount);
    double getBalance();

    static void printServiceStatus() {
        System.out.println("Платежный шлюз активен");
    }
}

interface Secure {
    void authenticate(String password);
    void logout();
}

class PayPal implements PaymentSystem, Secure {
    private String email;
    private double balance;
    private boolean authenticated;

    public PayPal(String email, double balance) {
        this.email = email;
        this.balance = balance;
        this.authenticated = false;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void authenticate(String password) {
        if ("pass123".equals(password)) {
            authenticated = true;
            System.out.println("PayPal [" + email + "]: вход выполнен");
        } else {
            System.out.println("PayPal [" + email + "]: неверный пароль");
        }
    }

    @Override
    public void logout() {
        authenticated = false;
        System.out.println("PayPal [" + email + "]: выход из системы");
    }

    @Override
    public void pay(double amount) {
        if (!authenticated) {
            System.out.println("PayPal [" + email + "]: ошибка — требуется авторизация");
            return;
        }
        if (balance >= amount) {
            balance -= amount;
            System.out.println("PayPal [" + email + "]: оплата " + amount + " выполнена. Остаток: " + balance);
        } else {
            System.out.println("PayPal [" + email + "]: недостаточно средств для оплаты " + amount);
        }
    }

    @Override
    public void refund(double amount) {
        balance += amount;
        System.out.println("PayPal [" + email + "]: возврат " + amount + " зачислен. Баланс: " + balance);
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

class CreditCard implements PaymentSystem, Secure {
    private String cardNumber;
    private double balance;
    private double limit;
    private boolean authenticated;

    public CreditCard(String cardNumber, double balance, double limit) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.limit = limit;
        this.authenticated = false;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getLimit() {
        return limit;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void authenticate(String password) {
        if ("0000".equals(password)) {
            authenticated = true;
            System.out.println("CreditCard [" + cardNumber + "]: PIN-код подтвержден");
        } else {
            System.out.println("CreditCard [" + cardNumber + "]: неверный PIN-код");
        }
    }

    @Override
    public void logout() {
        authenticated = false;
        System.out.println("CreditCard [" + cardNumber + "]: завершение обслуживания карты");
    }

    @Override
    public void pay(double amount) {
        if (!authenticated) {
            System.out.println("CreditCard [" + cardNumber + "]: ошибка — введите PIN-код");
            return;
        }
        if (balance + limit >= amount) {
            balance -= amount;
            System.out.println("CreditCard [" + cardNumber + "]: оплата " + amount + " выполнена. Баланс: " + balance);
        } else {
            System.out.println("CreditCard [" + cardNumber + "]: превышен лимит средств");
        }
    }

    @Override
    public void refund(double amount) {
        balance += amount;
        System.out.println("CreditCard [" + cardNumber + "]: возврат " + amount + " зачислен. Баланс: " + balance);
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentSystem.printServiceStatus();
        System.out.println();

        PaymentSystem[] accounts = new PaymentSystem[5];

        accounts[0] = new PayPal("ivanov@mail.ru", 500.0);
        accounts[1] = new PayPal("petrov@gmail.com", 100.0);

        accounts[2] = new CreditCard("4276-1111", 300.0, 200.0);
        accounts[3] = new CreditCard("5469-2222", 50.0, 300.0);
        accounts[4] = new CreditCard("2202-3333", 1000.0, 500.0);

        for (PaymentSystem payment : accounts) {
            Secure secureAccount = (Secure) payment;

            if (payment instanceof PayPal) {
                secureAccount.authenticate("pass123");
            } else {
                secureAccount.authenticate("0000");
            }

            payment.pay(200.0);
            payment.refund(50.0);
            System.out.println("Текущий баланс: " + payment.getBalance());
            secureAccount.logout();
            System.out.println();
        }
    }
}