package training.budget.model;

import javax.persistence.*;


//

/**
 * Аннотация @Entity используется для того, чтобы сообщить Hibernate, что класс взаимодействует с Hibernate.
 * Аннотация @Table - аннотация, используемая для явного указания названия таблицы.
 */
@Entity
@Table(name = "incomes")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "amount")
    private double amount;

    /**
     * Construcors
     */
    public Income() {
    }

    public Income(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    /**
     * Getters and Setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
