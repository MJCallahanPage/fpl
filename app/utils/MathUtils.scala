package utils

trait MathUtils {

  def mean(values: Seq[BigDecimal]): BigDecimal = values.sum / values.length

  def variance(values: Seq[BigDecimal]): BigDecimal = values.map { value =>
    val valueMinusMean = value - mean(values)
    valueMinusMean * valueMinusMean
  }.sum / values.length

  def stdDev(variance: Double): Double = {
    Math.sqrt(variance)
  }

  def standardise(value: BigDecimal, values: Seq[BigDecimal]): Unit = {
    (value - mean(values))/
      stdDev(variance(values).toDouble)
  }

}
