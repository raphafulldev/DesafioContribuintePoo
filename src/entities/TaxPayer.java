package entities;

public class TaxPayer {
    public Double salaryIncome;
    public Double servicesIncome;
    public Double capitalIncome;
    public Double healthSpending;
    public Double educationSpending;

    public TaxPayer() {
    }

    public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome,
                    Double healthSpending, Double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public Double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(Double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public Double getServicesIncome() {
        return servicesIncome;
    }

    public void setServicesIncome(Double servicesIncome) {
        this.servicesIncome = servicesIncome;
    }

    public Double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(Double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public Double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(Double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public Double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(Double educationSpending) {
        this.educationSpending = educationSpending;
    }

    // Calculo para 10 e 20 % de desconto
    public double salaryTax() {
        double monthlySalary = salaryIncome/12;
        double salaryTaxValue = 0.0;

        if(monthlySalary <  3000.0) {
            salaryTaxValue = 0.0;
        }
        else if(monthlySalary >= 3000.0 && monthlySalary <=  5000.0) {
            salaryTaxValue = salaryIncome * 0.10;
        }
        else {
            salaryTaxValue = salaryIncome * 0.20;
        }

        return salaryTaxValue;
    }

    //Imposto sobre serviços
    public double servicesTax() {
        return servicesIncome * 0.15;
    }

    //Imposto sobre ganhos de ccpital
    public double capitalTax() {
        return capitalIncome * 0.2;
    }

    // Imposto bruto
    public double grossTax() {
        return salaryTax() + servicesTax() + capitalTax();
    }

    // Abatimento permitido
    public double taxRebate() {
        double deductionLimit = 0.30 * grossTax();
        double totalDeductionExpenses = healthSpending + educationSpending;
        return Math.min(deductionLimit, totalDeductionExpenses);
    }

    public double netTax() {
        return grossTax() - taxRebate();

    }

}
