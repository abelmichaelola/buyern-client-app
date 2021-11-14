package com.buyern.buyern.Models;

public class Price {
   String currency;
   int main;
   int basePrice;

   public Price() {
   }

   public Price(String currency, int main, int basePrice) {
      this.currency = currency;
      this.main = main;
      this.basePrice = basePrice;
   }

   public String getCurrency() {
      return currency;
   }

   public void setCurrency(String currency) {
      this.currency = currency;
   }

   public int getMain() {
      return main;
   }

   public void setMain(int main) {
      this.main = main;
   }

   public int getBasePrice() {
      return basePrice;
   }

   public void setBasePrice(int basePrice) {
      this.basePrice = basePrice;
   }
}
