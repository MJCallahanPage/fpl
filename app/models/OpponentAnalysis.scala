package models

case class OpponentAnalysis(opponent: String,
                            home: Boolean,
                            opponentRating: BigDecimal,
                            opponentAttackRating: BigDecimal,
                            opponentDefenceRating: BigDecimal,
                            opponentForm: String
                           )
