package utils

import java.math.MathContext

trait MathUtils {

  def mean(values: Seq[BigDecimal]): BigDecimal = values.sum / values.length

  def variance(values: Seq[BigDecimal]): BigDecimal = values.map { value =>
    val valueMinusMean = value - mean(values)
    valueMinusMean * valueMinusMean
  }.sum / values.length

  def stdDev(variance: Double): Double = {
    Math.sqrt(variance)
  }

  def standardise(value: BigDecimal, values: Seq[BigDecimal]): BigDecimal = {
    ((value - mean(values)) /
      stdDev(variance(values).toDouble))
  }

  def std(value: BigDecimal, values: Seq[BigDecimal]): BigDecimal = {
    val standardised = ((standardise(value, values) * 2.5) + 5).setScale(1, BigDecimal.RoundingMode.HALF_UP)

    if(standardised > 10) 10 else standardised
  }

  def normalise(value: BigDecimal, values: Seq[BigDecimal]): BigDecimal = {
    ((value - values.min) / (values.max - values.min) * 10).setScale(1, BigDecimal.RoundingMode.HALF_UP)
  }
}
