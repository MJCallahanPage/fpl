package utils

import Ordering.Implicits._

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
    (value - mean(values)) /
      stdDev(variance(values).toDouble)
  }

  def minMaxBoundary[T : Numeric](value: T, min: T, max: T): T = {
    value match {
      case x if x <= min => min
      case x if x >= max => max
      case _ => value
    }
  }

  def std(value: BigDecimal, values: Seq[BigDecimal]): BigDecimal = {
    val standardised = ((standardise(value, values) * 2) + 5).setScale(1, BigDecimal.RoundingMode.HALF_UP)
    minMaxBoundary(standardised, 0, 10)
  }

  def normalise(value: BigDecimal, values: Seq[BigDecimal]): BigDecimal = {
    ((value - values.min) / (values.max - values.min) * 10).setScale(1, BigDecimal.RoundingMode.HALF_UP)
  }
}
