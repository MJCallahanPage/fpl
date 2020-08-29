package utils

trait CurrencyFormatter {
  def currencyFormat(amt: BigDecimal): String = f"£$amt%,1.1fm".replace(".0","")
}

object CurrencyFormatter extends CurrencyFormatter
