package models

case class OpponentAnalysis(opponent: String,
                            home: Boolean,
                            rating: BigDecimal,
                            attackRating: BigDecimal,
                            defenceRating: BigDecimal,
                            form: String
                           )
