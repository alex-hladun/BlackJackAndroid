package com.djrexx.nothing

import android.animation.*
import android.content.Context
import android.os.Bundle
import android.renderscript.Sampler
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_game.*
import org.w3c.dom.Text


class GameFragment : Fragment() {
    var balance = 1000
    var bet: Double = 25.00
    var dealingTable: Boolean = true
    val initPlayerCardX = -350f
    val initPlayerCardY = 700f
    val initDealerCardX = 370f
    val initDealerCardY = 450f
    var shiftX = 32f
    var shiftY = 16f
    var animDuration = 250L
    var animDurationRV = 250L
    var dealerAnimDuration = 400L
    var flipDuration = 125L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dealButton = view.findViewById<Button>(R.id.dealButton)
        val hitButton = view.findViewById<Button>(R.id.hitButton)
        val splitButton = view.findViewById<Button>(R.id.splitButton)
        val doubleButton = view.findViewById<Button>(R.id.doubleButton)
        val standButton = view.findViewById<Button>(R.id.standButton)
        val posBetButton = view.findViewById<Button>(R.id.posChangeBet)
        val negBetButton = view.findViewById<Button>(R.id.negChangeBet)
        val playerInfoText = view.findViewById<TextView>(R.id.playerInfoText)
        val dealerScoretext = view.findViewById<TextView>(R.id.dealerScoreText)
        dealerScoretext.visibility = View.GONE
        val cardView = view.findViewById<ImageView>(R.id.cardView)
        val cardView2 = view.findViewById<ImageView>(R.id.cardView2)
        val cardView10 = view.findViewById<ImageView>(R.id.cardView10)
        val cardView3 = view.findViewById<ImageView>(R.id.cardView3)
        val cardView4 = view.findViewById<ImageView>(R.id.cardView4)
        val cardView5 = view.findViewById<ImageView>(R.id.cardView5)
        val cardView6 = view.findViewById<ImageView>(R.id.cardView7)
        val cardView7 = view.findViewById<ImageView>(R.id.cardView2)
        val cardView8 = view.findViewById<ImageView>(R.id.cardView8)
        val cardView9 = view.findViewById<ImageView>(R.id.cardView9)
        val dealerInfoText = view.findViewById<TextView>(R.id.dealerInfoText)
        val dealerCardView = view.findViewById<ImageView>(R.id.dealerCardView)
        val dealerCardView2 = view.findViewById<ImageView>(R.id.dealerCardView2)
        val dealerCardView3 = view.findViewById<ImageView>(R.id.dealerCardView3)
        val dealerCardView4 = view.findViewById<ImageView>(R.id.dealerCardView4)
        val dealerCardView5 = view.findViewById<ImageView>(R.id.dealerCardView5)
        val dealerCardView6 = view.findViewById<ImageView>(R.id.dealerCardView6)
        val dealerCardView7 = view.findViewById<ImageView>(R.id.dealerCardView7)
        val dealerCardView8 = view.findViewById<ImageView>(R.id.dealerCardView8)
        val dealerCardView9 = view.findViewById<ImageView>(R.id.dealerCardView9)
        val dealerCardView10 = view.findViewById<ImageView>(R.id.dealerCardView10)
        var betAmount = view.findViewById<TextView>(R.id.betAmountText)
        var accountBalance = view.findViewById<TextView>(R.id.accountBalance)
        val translateYAnimation = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initPlayerCardY)
        val translateXAnimation = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initPlayerCardX)
        val rotateAnimation = PropertyValuesHolder.ofFloat(View.ROTATION, 0f)
        val alphaAnimation = PropertyValuesHolder.ofFloat(View.ALPHA, 1f)
        val translateYAnimation2 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initPlayerCardY + shiftY)
        val translateXAnimation2 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initPlayerCardX + shiftX)
        val translateYAnimation3 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initPlayerCardY + 2 * shiftY)
        val translateXAnimation3 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initPlayerCardX + 2 * shiftX)
        val translateYAnimation4 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initPlayerCardY + 3 * shiftY)
        val translateXAnimation4 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initPlayerCardX + 3 * shiftX)
        val translateYAnimation5 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initPlayerCardY + 4 * shiftY)
        val translateXAnimation5 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initPlayerCardX + 4 * shiftX)
        val translateYAnimation6 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initPlayerCardY + 5 * shiftY)
        val translateXAnimation6 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initPlayerCardX + 5 * shiftX)
        val translateYAnimation7 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initPlayerCardY + 6 * shiftY)
        val translateXAnimation7 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initPlayerCardX + 6 * shiftX)
        val translateYAnimation8 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initPlayerCardY + 7 * shiftY)
        val translateXAnimation8 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initPlayerCardX + 7 * shiftX)
        val translateYAnimation9 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initPlayerCardY + 8 * shiftY)
        val translateXAnimation9 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initPlayerCardX + 8 * shiftX)
        val translateYAnimation10 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initPlayerCardY + 9 * shiftY)
        val translateXAnimation10 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initPlayerCardX + 9 * shiftX)
        val translateYAnimationDealer =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initDealerCardY)
        val translateXAnimationDealer =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initDealerCardX)
        val translateYAnimationDealer2 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initDealerCardY + shiftY)
        val translateXAnimationDealer2 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initDealerCardX + shiftX)
        val translateYAnimationDealer3 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initDealerCardY + 2 * shiftY)
        val translateXAnimationDealer3 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initDealerCardX + 2 * shiftX)
        val translateYAnimationDealer4 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initDealerCardY + 3 * shiftY)
        val translateXAnimationDealer4 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initDealerCardX + 3 * shiftX)
        val translateYAnimationDealer5 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initDealerCardY + 4 * shiftY)
        val translateXAnimationDealer5 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initDealerCardX + 4 * shiftX)
        val translateYAnimationDealer6 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initDealerCardY + 5 * shiftY)
        val translateXAnimationDealer6 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initDealerCardX + 5 * shiftX)
        val translateYAnimationDealer7 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initDealerCardY + 6 * shiftY)
        val translateXAnimationDealer7 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initDealerCardX + 6 * shiftX)
        val translateYAnimationDealer8 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initDealerCardY + 7 * shiftY)
        val translateXAnimationDealer8 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initDealerCardX + 7 * shiftX)
        val translateYAnimationDealer9 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initDealerCardY + 8 * shiftY)
        val translateXAnimationDealer9 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initDealerCardX + 8 * shiftX)
        val translateYAnimationDealer10 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initDealerCardY + 9 * shiftY)
        val translateXAnimationDealer10 =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initDealerCardX + 9 * shiftX)

        val translateYAnimationRV = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, -initPlayerCardY)
        val translateXAnimationRV = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, -initPlayerCardX)
        val rotateAnimationRV = PropertyValuesHolder.ofFloat(View.ROTATION, -160f)
        val alphaAnimationRV = PropertyValuesHolder.ofFloat(View.ALPHA, 0f)
        val translateYAnimation2RV =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, -initPlayerCardY - shiftY)
        val translateXAnimation2RV =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, -initPlayerCardX - shiftX)
//        val translateYAnimation3 =
//            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initPlayerCardY + 2 * shiftY)
//        val translateXAnimation3 =
//            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initPlayerCardX + 2 * shiftX)
//        val translateYAnimation4 =
//            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initPlayerCardY + 3 * shiftY)
//        val translateXAnimation4 =
//            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initPlayerCardX + 3 * shiftX)
//        val translateYAnimation5 =
//            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initPlayerCardY + 4 * shiftY)
//        val translateXAnimation5 =
//            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initPlayerCardX + 4 * shiftX)
//        val translateYAnimation6 =
//            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initPlayerCardY + 5 * shiftY)
//        val translateXAnimation6 =
//            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initPlayerCardX + 5 * shiftX)
//        val translateYAnimation7 =
//            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initPlayerCardY + 6 * shiftY)
//        val translateXAnimation7 =
//            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initPlayerCardX + 6 * shiftX)
//        val translateYAnimation8 =
//            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initPlayerCardY + 7 * shiftY)
//        val translateXAnimation8 =
//            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initPlayerCardX + 7 * shiftX)
//        val translateYAnimation9 =
//            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initPlayerCardY + 8 * shiftY)
//        val translateXAnimation9 =
//            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initPlayerCardX + 8 * shiftX)
//        val translateYAnimation10 =
//            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, initPlayerCardY + 9 * shiftY)
//        val translateXAnimation10 =
//            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, initPlayerCardX + 9 * shiftX)

        val flipCard = PropertyValuesHolder.ofFloat(View.ROTATION_Y, 0f)
        val cardFlipAnim = ObjectAnimator.ofPropertyValuesHolder(dealerCardView2, flipCard)

        val flipCard2 = PropertyValuesHolder.ofFloat(View.ROTATION_Y, 90f)
        val cardFlipAnim2 = ObjectAnimator.ofPropertyValuesHolder(dealerCardView2, flipCard2)

        cardFlipAnim.duration = flipDuration
        cardFlipAnim2.duration = flipDuration

        val card1Anim = ObjectAnimator.ofPropertyValuesHolder(
            cardView,
            translateXAnimation,
            translateYAnimation,
            rotateAnimation,
            alphaAnimation
        )
        card1Anim.duration = animDuration

        val card1AnimRV = ObjectAnimator.ofPropertyValuesHolder(
            cardView,
            translateXAnimationRV,
            translateYAnimationRV,
            rotateAnimationRV,
            alphaAnimationRV
        )
        card1AnimRV.duration = animDurationRV

        val card2Anim = ObjectAnimator.ofPropertyValuesHolder(
            dealerCardView,
            translateXAnimationDealer,
            translateYAnimationDealer,
            rotateAnimation,
            alphaAnimation
        )
        card2Anim.duration = animDuration

        val card3Anim = ObjectAnimator.ofPropertyValuesHolder(
            cardView2,
            translateXAnimation2,
            translateYAnimation2,
            rotateAnimation,
            alphaAnimation
        )
        card3Anim.duration = animDuration

        val card3AnimRV = ObjectAnimator.ofPropertyValuesHolder(
            cardView2,
            translateXAnimation2RV,
            translateYAnimation2RV,
            rotateAnimationRV,
            alphaAnimationRV
        )
        card3AnimRV.duration = animDurationRV

        val card4Anim = ObjectAnimator.ofPropertyValuesHolder(
            dealerCardView2,
            translateXAnimationDealer2,
            translateYAnimationDealer2,
            rotateAnimation,
            alphaAnimation
        )
        card4Anim.duration = animDuration
        val card5Anim = ObjectAnimator.ofPropertyValuesHolder(
            cardView3,
            translateXAnimation3,
            translateYAnimation3,
            rotateAnimation,
            alphaAnimation
        )
        card5Anim.duration = animDuration
        val card6Anim = ObjectAnimator.ofPropertyValuesHolder(
            cardView4,
            translateXAnimation4,
            translateYAnimation4,
            rotateAnimation,
            alphaAnimation
        )
        card6Anim.duration = animDuration
        val card7Anim = ObjectAnimator.ofPropertyValuesHolder(
            cardView5,
            translateXAnimation5,
            translateYAnimation5,
            rotateAnimation,
            alphaAnimation
        )
        card7Anim.duration = animDuration
        val card8Anim = ObjectAnimator.ofPropertyValuesHolder(
            cardView6,
            translateXAnimation6,
            translateYAnimation6,
            rotateAnimation,
            alphaAnimation
        )
        card8Anim.duration = animDuration
        val card9Anim = ObjectAnimator.ofPropertyValuesHolder(
            cardView7,
            translateXAnimation7,
            translateYAnimation7,
            rotateAnimation,
            alphaAnimation
        )
        card9Anim.duration = animDuration
        val card10Anim = ObjectAnimator.ofPropertyValuesHolder(
            cardView8,
            translateXAnimation8,
            translateYAnimation8,
            rotateAnimation,
            alphaAnimation
        )
        card10Anim.duration = animDuration
        val card11Anim = ObjectAnimator.ofPropertyValuesHolder(
            cardView9,
            translateXAnimation9,
            translateYAnimation9,
            rotateAnimation,
            alphaAnimation
        )
        card11Anim.duration = animDuration
        val card12Anim = ObjectAnimator.ofPropertyValuesHolder(
            cardView10,
            translateXAnimation10,
            translateYAnimation10,
            rotateAnimation,
            alphaAnimation
        )
        card12Anim.duration = animDuration
        val card13Anim = ObjectAnimator.ofPropertyValuesHolder(
            dealerCardView3,
            translateXAnimationDealer3,
            translateYAnimationDealer3,
            rotateAnimation,
            alphaAnimation
        )
        card13Anim.duration = dealerAnimDuration
        val card14Anim = ObjectAnimator.ofPropertyValuesHolder(
            dealerCardView4,
            translateXAnimationDealer4,
            translateYAnimationDealer4,
            rotateAnimation,
            alphaAnimation
        )
        card14Anim.duration = dealerAnimDuration
        val card15Anim = ObjectAnimator.ofPropertyValuesHolder(
            dealerCardView5,
            translateXAnimationDealer5,
            translateYAnimationDealer5,
            rotateAnimation,
            alphaAnimation
        )
        card15Anim.duration = dealerAnimDuration
        val card16Anim = ObjectAnimator.ofPropertyValuesHolder(
            dealerCardView6,
            translateXAnimationDealer6,
            translateYAnimationDealer6,
            rotateAnimation,
            alphaAnimation
        )
        card16Anim.duration = dealerAnimDuration
        val card17Anim = ObjectAnimator.ofPropertyValuesHolder(
            dealerCardView3,
            translateXAnimationDealer7,
            translateYAnimationDealer7,
            rotateAnimation,
            alphaAnimation
        )
        card17Anim.duration = dealerAnimDuration
        val card18Anim = ObjectAnimator.ofPropertyValuesHolder(
            dealerCardView8,
            translateXAnimationDealer8,
            translateYAnimationDealer8,
            rotateAnimation,
            alphaAnimation
        )
        card18Anim.duration = dealerAnimDuration
        val card19Anim = ObjectAnimator.ofPropertyValuesHolder(
            dealerCardView9,
            translateXAnimationDealer9,
            translateYAnimationDealer9,
            rotateAnimation,
            alphaAnimation
        )
        card19Anim.duration = dealerAnimDuration
        val card20Anim = ObjectAnimator.ofPropertyValuesHolder(
            dealerCardView10,
            translateXAnimationDealer10,
            translateYAnimationDealer10,
            rotateAnimation,
            alphaAnimation
        )
        card20Anim.duration = dealerAnimDuration


        val sequenceAnimator = AnimatorSet()

        fun animateDeal() {
//            sequenceAnimator.reverse()
            sequenceAnimator.playSequentially(card1Anim, card2Anim, card3Anim, card4Anim)
            sequenceAnimator.start()
        }


        fun animatePlayerCard(playerHand: Hand, hn: Int, reverse : Boolean) {
//            Animates the single card that needs to be added to the player hand.
            var playerCardCount = playerHand.handArray[hn].size
            when (playerCardCount) {
                2 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card3Anim)
                    playerAnimator.start()
                }
                3 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card5Anim)
                    playerAnimator.start()
                }
                4 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card6Anim)
                    playerAnimator.start()
                }
                5 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card7Anim)
                    playerAnimator.start()
                }
                6 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card8Anim)
                    playerAnimator.start()
                }
                7 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card9Anim)
                    playerAnimator.start()
                }
                8 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card10Anim)
                    playerAnimator.start()
                }
                9 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card11Anim)
                    playerAnimator.start()
                }
                10 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card12Anim)
                    playerAnimator.start()
                }
            }
        }

        fun animatePlayerCardRV(playerHand: Hand, hn: Int, reverseCount: Int) {
//            Reverse-Animate the single card that needs to be added to the player hand.
//            var playerCardCount = playerHand.handArray[hn].size
            when (reverseCount) {
//                1 & 2 generally not used
                1 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card3AnimRV)
                    playerAnimator.start()
                }
                2 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card1AnimRV, card3AnimRV)
                    playerAnimator.start()
                }

                3 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card5Anim)
                    playerAnimator.start()
                }
                4 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card6Anim)
                    playerAnimator.start()
                }
                5 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card7Anim)
                    playerAnimator.start()
                }
                6 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card8Anim)
                    playerAnimator.start()
                }
                7 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card9Anim)
                    playerAnimator.start()
                }
                8 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card10Anim)
                    playerAnimator.start()
                }
                9 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card11Anim)
                    playerAnimator.start()
                }
                10 -> {
                    val playerAnimator = AnimatorSet()
                    playerAnimator.playSequentially(card12Anim)
                    playerAnimator.start()
                }
            }
        }

        fun animateDealerCard(dealerHand: Hand, delayAnim2:ObjectAnimator) {
//            Shows the animation for the dealing of all dealer cards.
            val flipCard = PropertyValuesHolder.ofFloat(View.ROTATION_Y, 0f)
            val cardFlipAnim = ObjectAnimator.ofPropertyValuesHolder(dealerCardView2, flipCard)
            cardFlipAnim.duration = flipDuration
            val delayAnim = ObjectAnimator.ofFloat(dealerCardView, View.ALPHA, 1f)

            delayAnim.duration = 300
            var dealerCardCount = dealerHand.handArray[0].size

            when (dealerCardCount) {
                2 -> {
                    val dealerAnimator = AnimatorSet()
                    dealerAnimator.playSequentially(cardFlipAnim, delayAnim2)
                    dealerAnimator.start()
                }
                3 -> {
                    val dealerAnimator = AnimatorSet()
                    dealerAnimator.playSequentially(cardFlipAnim, delayAnim, card13Anim, delayAnim2)
                    dealerAnimator.start()
                }
                4 -> {
                    val dealerAnimator = AnimatorSet()
                    dealerAnimator.playSequentially(cardFlipAnim, delayAnim, card13Anim, card14Anim, delayAnim2)
                    dealerAnimator.start()
                }
                5 -> {
                    val dealerAnimator = AnimatorSet()
                    dealerAnimator.playSequentially(cardFlipAnim,delayAnim, card13Anim, card14Anim, card15Anim, delayAnim2)
                    dealerAnimator.start()
                }
                6 -> {
                    val dealerAnimator = AnimatorSet()
                    dealerAnimator.playSequentially(cardFlipAnim, card13Anim, card14Anim, card15Anim, card16Anim, delayAnim2)
                    dealerAnimator.start()
                }
                7 -> {
                    val dealerAnimator = AnimatorSet()
                    dealerAnimator.playSequentially(
                        card13Anim,
                        card14Anim,
                        card15Anim,
                        card16Anim,
                        card17Anim,
                        delayAnim2
                    )
                    dealerAnimator.start()
                }
                8 -> {
                    val dealerAnimator = AnimatorSet()
                    dealerAnimator.playSequentially(
                        card13Anim,
                        card14Anim,
                        card15Anim,
                        card16Anim,
                        card17Anim,
                        card18Anim,
                        delayAnim2
                    )
                    dealerAnimator.start()
                }
                9 -> {
                    val dealerAnimator = AnimatorSet()
                    dealerAnimator.playSequentially(
                        card13Anim,
                        card14Anim,
                        card15Anim,
                        card16Anim,
                        card17Anim,
                        card18Anim,
                        card19Anim,
                        delayAnim2
                    )
                    dealerAnimator.start()
                }
                10 -> {
                    val dealerAnimator = AnimatorSet()
                    dealerAnimator.playSequentially(
                        card13Anim,
                        card14Anim,
                        card15Anim,
                        card16Anim,
                        card17Anim,
                        card18Anim,
                        card19Anim,
                        card20Anim,
                        delayAnim2
                    )
                    dealerAnimator.start()
                }
            }
        }

        fun resetButtons() {
            dealButton.visibility = View.VISIBLE
            negBetButton.visibility = View.VISIBLE
            posBetButton.visibility = View.VISIBLE
            splitButton.visibility = View.GONE
            doubleButton.visibility = View.GONE
            hitButton.visibility = View.GONE
            standButton.visibility = View.GONE
        }

        fun buttonDealMode() {
//            runs after the player hits stand
            splitButton.visibility = View.GONE
            doubleButton.visibility = View.GONE
            hitButton.visibility = View.GONE
            standButton.visibility = View.GONE
        }

        fun hideButtons() {
//            runs after main play function (after deal is clicked). Hides the deal button, etc.
            dealerCardView3.animate().translationX(0f).translationY(0f).setDuration(1)
            dealerCardView4.animate().translationX(0f).translationY(0f).setDuration(1)
            dealerCardView5.animate().translationX(0f).translationY(0f).setDuration(1)
            dealerCardView6.animate().translationX(0f).translationY(0f).setDuration(1)
            dealerCardView7.animate().translationX(0f).translationY(0f).setDuration(1)
            dealerCardView8.animate().translationX(0f).translationY(0f).setDuration(1)
            dealerCardView9.animate().translationX(0f).translationY(0f).setDuration(1)
            dealerCardView10.animate().translationX(0f).translationY(0f).setDuration(1)
            dealerScoretext.visibility = View.GONE
            dealButton.visibility = View.GONE
            dealerInfoText.visibility = View.GONE
            negBetButton.visibility = View.GONE
            posBetButton.visibility = View.GONE
            splitButton.visibility = View.GONE
            doubleButton.visibility = View.GONE
            standButton.visibility = View.GONE
            hitButton.visibility = View.GONE
            cardView3.visibility = View.INVISIBLE
            cardView4.visibility = View.INVISIBLE
            cardView5.visibility = View.GONE
            cardView6.visibility = View.GONE
            cardView7.visibility = View.GONE
            cardView8.visibility = View.GONE
            cardView9.visibility = View.GONE
            cardView10.visibility = View.GONE
            dealerCardView2.setImageResource(R.drawable.gray_back)
            dealerCardView3.visibility = View.GONE
            dealerCardView4.visibility = View.GONE
            dealerCardView5.visibility = View.GONE
            dealerCardView6.visibility = View.GONE
            dealerCardView7.visibility = View.GONE
            dealerCardView8.visibility = View.GONE
            dealerCardView9.visibility = View.GONE
            dealerCardView10.visibility = View.GONE
        }

        fun updateBalance() {
            val newBalance = getString(R.string.account_balance, balance)
            accountBalance.text = newBalance
        }

        fun updateBetAmount() {
            val newBet = getString(R.string.bet_amount_text, bet)
            betAmount.text = newBet
        }

//        Update the Balance. Update Bet Amount refreshes the bet amount on the screen .
        updateBetAmount()
        updateBalance()

        posBetButton.setOnClickListener { _ ->
            if (bet < balance) {
                bet += 5
                updateBetAmount()
            } else {
//                need a toast
            }
        }

        negBetButton.setOnClickListener { _ ->
            if (bet >= 5) {
                bet -= 5
                updateBetAmount()
            }
        }

        fun updateCardImg(hand: Hand, cardToUpdate: ImageView, hn: Int, cn: Int) {
//            Function to update the actual image of the cards. Doesn't animate card.
            if (hand.handArray[hn][cn].suit == "Spades") {
                when (hand.handArray[hn][cn].rank) {
                    "Ace" -> cardToUpdate.setImageResource(R.drawable.card_as)
                    "Two" -> cardToUpdate.setImageResource(R.drawable.card_2s)
                    "Three" -> cardToUpdate.setImageResource(R.drawable.card_3s)
                    "Four" -> cardToUpdate.setImageResource(R.drawable.card_4s)
                    "Five" -> cardToUpdate.setImageResource(R.drawable.card_5s)
                    "Six" -> cardToUpdate.setImageResource(R.drawable.card_6s)
                    "Seven" -> cardToUpdate.setImageResource(R.drawable.card_7s)
                    "Eight" -> cardToUpdate.setImageResource(R.drawable.card_8s)
                    "Nine" -> cardToUpdate.setImageResource(R.drawable.card_9s)
                    "Ten" -> cardToUpdate.setImageResource(R.drawable.card_10s)
                    "Jack" -> cardToUpdate.setImageResource(R.drawable.card_js)
                    "Queen" -> cardToUpdate.setImageResource(R.drawable.card_qs)
                    "King" -> cardToUpdate.setImageResource(R.drawable.card_ks)
                }
            }
            if (hand.handArray[hn][cn].suit == "Hearts") {
                when (hand.handArray[hn][cn].rank) {
                    "Ace" -> cardToUpdate.setImageResource(R.drawable.card_ah)
                    "Two" -> cardToUpdate.setImageResource(R.drawable.card_2h)
                    "Three" -> cardToUpdate.setImageResource(R.drawable.card_3h)
                    "Four" -> cardToUpdate.setImageResource(R.drawable.card_4h)
                    "Five" -> cardToUpdate.setImageResource(R.drawable.card_5h)
                    "Six" -> cardToUpdate.setImageResource(R.drawable.card_6h)
                    "Seven" -> cardToUpdate.setImageResource(R.drawable.card_7h)
                    "Eight" -> cardToUpdate.setImageResource(R.drawable.card_8h)
                    "Nine" -> cardToUpdate.setImageResource(R.drawable.card_9h)
                    "Ten" -> cardToUpdate.setImageResource(R.drawable.card_10h)
                    "Jack" -> cardToUpdate.setImageResource(R.drawable.card_jh)
                    "Queen" -> cardToUpdate.setImageResource(R.drawable.card_qh)
                    "King" -> cardToUpdate.setImageResource(R.drawable.card_kh)
                }
            }
            if (hand.handArray[hn][cn].suit == "Clubs") {
                when (hand.handArray[hn][cn].rank) {
                    "Ace" -> cardToUpdate.setImageResource(R.drawable.card_ac)
                    "Two" -> cardToUpdate.setImageResource(R.drawable.card_2c)
                    "Three" -> cardToUpdate.setImageResource(R.drawable.card_3c)
                    "Four" -> cardToUpdate.setImageResource(R.drawable.card_4c)
                    "Five" -> cardToUpdate.setImageResource(R.drawable.card_5c)
                    "Six" -> cardToUpdate.setImageResource(R.drawable.card_6c)
                    "Seven" -> cardToUpdate.setImageResource(R.drawable.card_7c)
                    "Eight" -> cardToUpdate.setImageResource(R.drawable.card_8c)
                    "Nine" -> cardToUpdate.setImageResource(R.drawable.card_9c)
                    "Ten" -> cardToUpdate.setImageResource(R.drawable.card_10c)
                    "Jack" -> cardToUpdate.setImageResource(R.drawable.card_jc)
                    "Queen" -> cardToUpdate.setImageResource(R.drawable.card_qc)
                    "King" -> cardToUpdate.setImageResource(R.drawable.card_kc)
                }
            }
            if (hand.handArray[hn][cn].suit == "Diamonds") {
                when (hand.handArray[hn][cn].rank) {
                    "Ace" -> cardToUpdate.setImageResource(R.drawable.card_ad)
                    "Two" -> cardToUpdate.setImageResource(R.drawable.card_2d)
                    "Three" -> cardToUpdate.setImageResource(R.drawable.card_3d)
                    "Four" -> cardToUpdate.setImageResource(R.drawable.card_4d)
                    "Five" -> cardToUpdate.setImageResource(R.drawable.card_5d)
                    "Six" -> cardToUpdate.setImageResource(R.drawable.card_6d)
                    "Seven" -> cardToUpdate.setImageResource(R.drawable.card_7d)
                    "Eight" -> cardToUpdate.setImageResource(R.drawable.card_8d)
                    "Nine" -> cardToUpdate.setImageResource(R.drawable.card_9d)
                    "Ten" -> cardToUpdate.setImageResource(R.drawable.card_10d)
                    "Jack" -> cardToUpdate.setImageResource(R.drawable.card_jd)
                    "Queen" -> cardToUpdate.setImageResource(R.drawable.card_qd)
                    "King" -> cardToUpdate.setImageResource(R.drawable.card_kd)
                }
            }
        }

        fun addCardImg(playerHand: Hand, hn : Int) {
            when (playerHand.handArray[0].size) {
                3 -> {
                    updateCardImg(playerHand, cardView3, hn, 2)
                    cardView3.visibility = View.VISIBLE
                }
                4 -> {
                    updateCardImg(playerHand, cardView4, hn, 3)
                    cardView4.visibility = View.VISIBLE
                }
                5 -> {
                    updateCardImg(playerHand, cardView5, hn, 4)
                    cardView5.visibility = View.VISIBLE
                }
                6 -> {
                    updateCardImg(playerHand, cardView6, hn, 5)
                    cardView6.visibility = View.VISIBLE
                }
                7 -> {
                    updateCardImg(playerHand, cardView7, hn, 6)
                    cardView7.visibility = View.VISIBLE
                }
                8 -> {
                    updateCardImg(playerHand, cardView8, hn, 7)
                    cardView8.visibility = View.VISIBLE
                }
                9 -> {
                    updateCardImg(playerHand, cardView9, hn, 8)
                    cardView9.visibility = View.VISIBLE
                }
                10 -> {
                    updateCardImg(playerHand, cardView10, hn, 9)
                    cardView10.visibility = View.VISIBLE
                }
            }
        }

        fun addDealerCardImg(dealerHand: Hand) {
            when (dealerHand.handArray[0].size) {
                2 -> {
                    updateCardImg(dealerHand, dealerCardView2, 0, 1)
                    dealerCardView2.visibility = View.VISIBLE
                }
                3 -> {
                    updateCardImg(dealerHand, dealerCardView3, 0, 2)
                    dealerCardView3.visibility = View.VISIBLE
                }
                4 -> {
                    updateCardImg(dealerHand, dealerCardView4, 0, 3)
                    dealerCardView4.visibility = View.VISIBLE
                }
                5 -> {
                    updateCardImg(dealerHand, dealerCardView5, 0, 4)
                    dealerCardView5.visibility = View.VISIBLE
                }
                6 -> {
                    updateCardImg(dealerHand, dealerCardView6, 0, 5)
                    dealerCardView6.visibility = View.VISIBLE
                }
                7 -> {
                    updateCardImg(dealerHand, dealerCardView7, 0, 6)
                    dealerCardView7.visibility = View.VISIBLE
                }
                8 -> {
                    updateCardImg(dealerHand, dealerCardView8, 0, 7)
                    dealerCardView8.visibility = View.VISIBLE
                }
                9 -> {
                    updateCardImg(dealerHand, dealerCardView9, 0, 8)
                    dealerCardView9.visibility = View.VISIBLE
                }
                10 -> {
                    updateCardImg(dealerHand, dealerCardView10, 0, 9)
                    dealerCardView10.visibility = View.VISIBLE
                }
            }
        }

        fun compareTable(playerHand: Hand, dealerHand: Hand) {
            for (x in 0 until (playerHand.handTotal.size)) {
                if (playerHand.handTotal.size > 1) {
//                    NOT APPLICABLE UNTIL SPLIT FEATURE ADDED
//                    println("Split Hand ${x + 1} of ${playerHand.handArray.size}:")
                    if (playerHand.handTotal[x].size == 0) {
//                        println("You busted")
                        continue
                    }
                    if (playerHand.moveCount[x] == 21) {
//                        println("You got a BlackJack!!!")
                        continue
                    }
                }
                if (dealerHand.dealerbust) {
//                    Adding next two lines to display dealers hand total
                    dealerScoretext.visibility = View.VISIBLE
                    dealerScoretext.text = getString(R.string.dealer_score_text, dealerHand.handTotal2[0])
                    dealerInfoText.text =
                        getString(R.string.player_win_text,playerHand.betArray[x].toInt())
                    dealerInfoText.setBackgroundColor(ContextCompat.getColor(dealerInfoText.context,R.color.win_green))
                    dealerInfoText.visibility = View.VISIBLE
                    this.balance += playerHand.betArray[x].toInt()
                    updateBalance()
                    resetButtons()
                    continue
                }
                if (playerHand.handTotal[x].max()!! > dealerHand.handTotal[0].max()!!) {
//                    Adding next two lines to display dealers hand total
                    dealerScoretext.visibility = View.VISIBLE
                    dealerScoretext.text = getString(R.string.dealer_score_text, dealerHand.handTotal2[0])


                    dealerInfoText.text = getString(
                        R.string.player_compare_win_text, playerHand.betArray[x].toInt())
                    dealerInfoText.setBackgroundColor(ContextCompat.getColor(dealerInfoText.context,R.color.win_green))
                    dealerInfoText.visibility = View.VISIBLE
                    this.balance += playerHand.betArray[x].toInt()
                    updateBalance()
                    resetButtons()
                    continue
                } else if (playerHand.handTotal[x].max() == dealerHand.handTotal[0].max()) {
                    //   Adding next two lines to display dealers hand total
                    dealerScoretext.visibility = View.VISIBLE
                    dealerScoretext.text = getString(R.string.dealer_score_text, dealerHand.handTotal2[0])
                    dealerInfoText.text = getString(
                        R.string.player_tie_text
                    )
                    dealerInfoText.setBackgroundColor(ContextCompat.getColor(dealerInfoText.context,R.color.tie_yellow))
                    dealerInfoText.visibility = View.VISIBLE
                    updateBalance()
                    resetButtons()
                    continue
                } else {
                    // Adding next two lines to display dealers hand total
                    dealerScoretext.visibility = View.VISIBLE
                    dealerScoretext.text = getString(R.string.dealer_score_text, dealerHand.handTotal2[0])
                    dealerInfoText.text = getString(
                        R.string.dealer_win_text, playerHand.betArray[x].toInt())
                    dealerInfoText.setBackgroundColor(ContextCompat.getColor(dealerInfoText.context,R.color.lose_red))
                    dealerInfoText.visibility = View.VISIBLE
                    this.balance -= playerHand.betArray[x].toInt()
                    updateBalance()
                    resetButtons()
                    continue
                }
            }
            this.dealingTable = false
            return
        }

        fun dealerHit(dealerHand: Hand, deck: MutableList<Card>) {
//            Hits until the dealer is either over 21 or returns final card count
            dealerHand.initialize(0)
            dealerHand.dealing = true
            while (dealerHand.dealing) {
                for (x in dealerHand.handTotal[0]) {
                    if (x == 17) {
                        for (y in dealerHand.handTotal[0]) {
                            if (y < 17) {
                                break
                            } else {
                                dealerHand.dealerbust = false
                                return
                            }
                        }
                    } else if (x > 16) {
                        dealerHand.dealerbust = false
                        return
                    }
                }

                dealerHand.hit(deck, 0)

                if (dealerHand.handArray[0].size > 2) {
                    addDealerCardImg(dealerHand)
                }

                dealerHand.moveTick(0)
                dealerHand.checkDealerBust()
            }
        }

        fun animateSplit() {
//            sequenceAnimator.reverse()
//            sequenceAnimator.start()
        }

        fun splitBetting(playerHand: Hand, deck: MutableList<Card>) {

            }


        fun play() {
            hideButtons()
            val deck = DeckOfCards().cardList
            deck.shuffle()
            val playerHand = Hand()
            playerHand.betArray.add(bet.toFloat())
            val dealerHand = Hand()
            var hN = 0
            playerHand.hit(deck, 0)
            dealerHand.hit(deck, 0)
            playerHand.hit(deck, 0)
            dealerHand.hit(deck, 0)
            playerHand.initialize(0)
            playerInfoText.text = getString(R.string.player_info_text, playerHand.handTotal[0])
            updateCardImg(playerHand, cardView, 0, 0)
            updateCardImg(playerHand, cardView2, 0, 1)
            cardView2.visibility = View.VISIBLE
            updateCardImg(dealerHand, dealerCardView, 0, 0)
            animateDeal()

            playerHand.blackJackCheck(this, 0)
            if (!playerHand.blackJack) {
                dealingTable = true
            } else {
                dealerInfoText.text = getString(
                    R.string.blackjack_win_text,(1.5*bet).toFloat()
                )
                dealerInfoText.setBackgroundColor(ContextCompat.getColor(dealerInfoText.context,R.color.win_green))
                dealerInfoText.visibility = View.VISIBLE
                dealingTable = false
                balance = ((balance + bet * 1.5).toInt())
                updateBalance()
                resetButtons()
            }

            if (dealingTable) {
                if (hN < (playerHand.handArray.size) + 1) {
                        //            Checks what moves are possible & Updates the buttons displayed to the user
                        playerHand.checkMove(this, 0)

                    fun splitButtonClick(hN : Int) {
                        if (hN == 0) {
                            animatePlayerCardRV(playerHand, hN, 1)
                        } else {
                            animatePlayerCardRV(playerHand, hN, 2)
                        }
                        playerHand.split(deck, hN)
                        if (hN < (playerHand.handArray.size)) {
                            if (playerHand.moveCount[hN] > 0) {

                            } else {
                                playerHand.initialize(hN)
                                playerInfoText.text =
                                    getString(R.string.player_info_text, playerHand.handTotal[hN])
                                updateCardImg(playerHand, cardView, hN, 0)
                                updateCardImg(playerHand, cardView2, hN, 1)
                                cardView2.visibility = View.VISIBLE
                                animatePlayerCard(playerHand,hN,false)

//                            UPDATE LATER
//                            playerHand.blackJackCheck(this,x)

//                            UPDATE LATER
//                    In case player gets a blackjack, we want to skip
//                            playerHand.splitting = playerHand.moveCount[x] <= 0

//                            while (playerHand.splitting) {
                                playerHand.checkMove(this,hN)
//                            }

                            }
                        }
//                    dealerHit(dealerHand,deck)
//                    cardRotateAnim.start()
                    }


                    splitButton.setOnClickListener { _ ->
                        splitButtonClick(hN)
                    }

                        //                Trigger when hit button is clicked.
                        fun hitButtonClick(hN: Int): Int {
                            if ((playerHand.handArray.size) == 1) {
                                playerHand.hit(deck, hN)
                                playerHand.checkHand(this, hN)
//                    Updates the visibility of player cards and updates images
                                addCardImg(playerHand, hN)
//                    Animates the single adding of player cards
                                animatePlayerCard(playerHand, hN, false)
//                        Occurs if bust condition. Sets dealingtable to false.
                                if (playerHand.handTotal[hN].size == 0) {
                                    this.dealingTable = false
                                    dealerInfoText.text = getString(
                                        R.string.player_busted_text,
                                        playerHand.betArray[hN].toInt()
                                    )
                                    dealerInfoText.setBackgroundColor(
                                        ContextCompat.getColor(
                                            dealerInfoText.context,
                                            R.color.lose_red
                                        )
                                    )
                                    dealerInfoText.visibility = View.VISIBLE
                                    playerInfoText.text =
                                        getString(R.string.player_info_text, playerHand.handTotal2[0])
                                    updateBalance()
                                    resetButtons()
                                } else {
                                    playerInfoText.text =
                                        getString(R.string.player_info_text, playerHand.handTotal[0])
                                    playerHand.checkMove(this, hN)
                                }
                            }
                            //when you have split at least once
                            else {
                                playerHand.hit(deck, hN)
                                playerHand.checkHand(this, hN)
                                addCardImg(playerHand, hN)
                                animatePlayerCard(playerHand, hN, false)
//                        Bust condition on hand
                                if (playerHand.handTotal[hN].size == 0) {
//                            Some sort of bust/delay animation
//                            dealerInfoText.text = getString(
//                                R.string.player_busted_text,
//                                playerHand.betArray[hN].toInt()
//                            )
//                            dealerInfoText.setBackgroundColor(
//                                ContextCompat.getColor(
//                                    dealerInfoText.context,
//                                    R.color.lose_red
//                                )
//                            )
//                            dealerInfoText.visibility = View.VISIBLE
                                    playerInfoText.text =
                                        getString(R.string.player_info_text, playerHand.handTotal2[hN])
                                    updateBalance()
//                            resetButtons()
                                    return hN + 1
                                } else {
                                    playerInfoText.text =
                                        getString(R.string.player_info_text, playerHand.handTotal[hN])
                                    playerHand.checkMove(this, hN)
                                    return hN
                                }
                            }
                            return hN
                        }

                        hitButton.setOnClickListener() { _ ->
                            hN = hitButtonClick(hN)
                            splitButtonClick(hN)
                        }

                        doubleButton.setOnClickListener { _ ->
//                            Took this OUT WhiLE WORKING ON SPLIT
//                            playerHand.double(deck, 0)
//                            playerHand.double(deck, 0)
//                            addCardImg(playerHand, 0)
//                            animatePlayerCard(playerHand, 0, false)
//                            playerHand.checkHand(this, 0)
////                checks for bust condition
//                            if (playerHand.handTotal[0].size == 0) {
//                                dealerInfoText.text = getString(
//                                    R.string.player_busted_text,
//                                    playerHand.betArray[0].toInt()
//                                )
//                                dealerInfoText.setBackgroundColor(
//                                    ContextCompat.getColor(
//                                        dealerInfoText.context,
//                                        R.color.lose_red
//                                    )
//                                )
//                                dealerInfoText.visibility = View.VISIBLE
//                                playerInfoText.text =
//                                    getString(R.string.player_info_text, playerHand.handTotal2[0])
//                                updateBalance()
//                                resetButtons()
//                            } else {
//                                playerInfoText.text =
//                                    getString(R.string.player_info_text, playerHand.handTotal2[0])
////                    checkmove necessary to remove double button
//                                playerHand.checkMove(this, 0)
//                                addDealerCardImg(dealerHand)
//                                dealerHit(dealerHand, deck)
////                        Starts Animation, which leads to compareTable function.
//                                cardRotateAnim.start()
                            }
//                adds and updates the image of the most recent card
                        }

                        standButton.setOnClickListener { _ ->
                            hN +=1
                        }
                    }

                val delayAnim2 = ObjectAnimator.ofFloat(dealerCardView, View.ALPHA, 1f).apply {
//                    The delay animation that is added after all the dealer cards are flipped.
//                    After it runs, it compares the table.
                    duration = 100
                    addListener(object: AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            compareTable(playerHand,dealerHand)
                        }
                    })
                }

                val cardRotateAnim =
                    ObjectAnimator.ofFloat(dealerCardView2, "rotationY", -90f).apply {
//                Primary card flip for dealer. Sets a listener so that the card image is updated, and then
//                the flip animation continues with animateDealerCard
                        duration = flipDuration
                        addListener(object : AnimatorListenerAdapter() {
                            override fun onAnimationEnd(animation: Animator?) {
                                super.onAnimationEnd(animation)
                                updateCardImg(dealerHand, dealerCardView2, 0, 1)
                                dealerCardView2.visibility = View.VISIBLE
                                animateDealerCard(dealerHand,delayAnim2)
                            }
                        })
                    }

                buttonDealMode()
                dealerHit(dealerHand, deck)
//                  Note: CardRotateAnim will trigger the comparetable function
                cardRotateAnim.start()



            }
            if (balance <= 0) {
                dealingTable = false
            }


        dealButton.setOnClickListener { _ ->
            play()
        }




//        fun compareTable(playerHand: Hand, dealerHand: Hand) {
////            compares the players hand(s) to the dealers hand
//            for (x in 0 until (playerHand.handTotal.size)) {
//                if (playerHand.handTotal.size > 1) {
//                    println("Split Hand ${x + 1} of ${playerHand.handArray.size}:")
//                    if (playerHand.handTotal[x].size == 0) {
//                        println("You busted")
//                        continue
//                    }
//                    if (playerHand.moveCount[x] == 21) {
//                        println("You got a BlackJack!!!")
//                        continue
//                    }
//                }
//                var playerMax = playerHand.handTotal[x].max()
//                var dealerMax = dealerHand.handTotal[0].max()
//                if (dealerHand.dealerbust) {
//                    println("You have ${playerHand.handTotal[x].max()} and Dealer busted!!!")
//                    this.balance += playerHand.betArray[x].toInt()
//                    continue
//                }
//                if (playerHand.handTotal[x].max()!! > dealerHand.handTotal[0].max()!!) {
//                    println("You have ${playerHand.handTotal[x].max()} and dealer has ${dealerHand.handTotal[0].max()}")
//                    println("Player wins hand!!!")
//                    this.balance += playerHand.betArray[x].toInt()
//                    continue
//                } else if (playerHand.handTotal[x].max() == dealerHand.handTotal[0].max()) {
//                    println("You have ${playerHand.handTotal[x].max()}, dealer also has ${dealerHand.handTotal[0].max()}")
//                    println("Tie!")
//                    continue
//                } else {
//                    println("You have ${playerHand.handTotal[x].max()}, dealer has ${dealerHand.handTotal[0].max()}")
//                    println("Dealer wins hand!")
//                    this.balance -= playerHand.betArray[x].toInt()
//                    continue
//                }
//            }
//            this.dealingTable = false
//            return
//        }


        play()


    }


}

data class Card(
    val suit: String,
    val rank: String,
    val faceVal: Int
)

class DeckOfCards() {
    var cardList = mutableListOf<Card>()

    init {
        var suitList = listOf("Spades", "Hearts", "Clubs", "Diamonds")
        var rankList =
            listOf(
                "Ace",
                "Two",
                "Three",
                "Four",
                "Five",
                "Six",
                "Seven",
                "Eight",
                "Nine",
                "Ten",
                "Jack",
                "Queen",
                "King"
            )
        var faceValList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10)
        for (suit in suitList) {
            var i = 0
            for (rank in rankList) {
                cardList.add(Card(suit, rank, faceValList[i]))
                i++
            }
        }
    }

    fun shuffleDeck(): MutableList<Card> {
        cardList.shuffle()
//        println("Shuffling Deck")
        return cardList
    }
}



open class Hand() {
    var handTotal = mutableListOf<MutableList<Int>>(mutableListOf<Int>())
    var handTotal2 = mutableListOf<MutableList<Int>>(mutableListOf<Int>())
    var handArray = mutableListOf<MutableList<Card>>(mutableListOf<Card>())
    var betArray = mutableListOf<Float>()
    var moveCount = arrayListOf<Int>(0)
    var blackJack = false
    var move: String? = "j"
    var splitting = false
    var dealing = true
    var dealerbust = false

    fun hit(deck: MutableList<Card>, hn: Int) {
        this.handArray[hn].add(deck.removeAt(0))
    }

    fun double(deck: MutableList<Card>, hn: Int) {
        var betCheck = this.betArray[hn]
        this.betArray[hn] = 2 * betCheck
        this.hit(deck, hn)
    }

    fun moveTick(hn: Int) {
        this.moveCount[hn]++
    }


    fun checkHand(player: GameFragment, hn: Int) {
//        """Calculates the hand score.
//        Determine handtotal. if it has ace
//        add 1 to existing values and then append an 11.
//        Also checks for bust condition, which stops the dealing"""
//        val scoreArraySize = this.handTotal[hn].size

        if (this.handArray[hn].last().faceVal == 1) {
            for (i in 0 until (this.handTotal[hn].size)) {
                this.handTotal[hn].add(this.handTotal[hn][i] + 10)
            }
            for (i in 0 until (this.handTotal[hn].size)) {
                this.handTotal[hn][i] = (this.handTotal[hn][i] + 1)
            }
        } else {
            for (i in 0 until (this.handTotal[hn].size)) {
                this.handTotal[hn][i] += this.handArray[hn].last().faceVal
            }
        }

//        Re-creates hand total as a list, then moves to this.handTotal
        var handTotal = mutableListOf<Int>()
        this.handTotal2[hn].clear()
        for (x in this.handTotal[hn]) {
//            Second list for handtotals
            this.handTotal2[hn].add(x)
            if (x <= 21) {
                handTotal.add(x)
            }
        }

        this.handTotal[hn].clear()
        for (x in handTotal) {
            this.handTotal[hn].add(x)
        }

        if (handTotal.size == 0) {
//          Bust condition
            player.balance -= this.betArray[hn].toInt()

//            player.dealingTable = false
            this.splitting = false
            return
        }
        player.dealingTable = true
        return
    }

    fun initialize(hn: Int) {
//        Takes the initial hand (player or dealer) and calculates the hand value(s),
//        dependent on the presence of aces or not

        this.handTotal[hn] = mutableListOf<Int>()

        if ((this.handArray[hn][0].faceVal == 1) && (this.handArray[hn][1].faceVal == 1)) {
            this.handTotal[hn].add(2)
            this.handTotal[hn].add(12)
        } else if (this.handArray[hn][0].faceVal == 1) {
            this.handTotal[hn].add(1 + this.handArray[hn][1].faceVal)
            this.handTotal[hn].add(11 + this.handArray[hn][1].faceVal)
        } else if (this.handArray[hn][1].faceVal == 1) {
            this.handTotal[hn].add(1 + this.handArray[hn][0].faceVal)
            this.handTotal[hn].add(11 + this.handArray[hn][0].faceVal)
        } else {
            this.handTotal[hn].add(this.handArray[hn][0].faceVal + this.handArray[hn][1].faceVal)
        }

        for(x in this.handTotal[hn]) {
            this.handTotal2[hn].add(x)
        }
    }

    fun blackJackCheck(player: GameFragment, hn: Int) {
        for (x in this.handTotal[hn]) {
            if (x == 21) {
                println("Blackjack!!!!")
                this.moveCount[hn] = 21
                this.blackJack = true
                player.dealingTable = false
            }
        }
    }

    fun checkMove(player: GameFragment, hn: Int) {
//        Check what moves are possible (Double only on first hand, split only if rank is equal)

        if (this.handArray[hn].size == 2) {
            if (this.handArray[hn][0].rank == this.handArray[hn][1].rank) {

                var betCheck = betArray.sum() + betArray[hn]
                if (betCheck < player.balance) {
                    player.splitButton.visibility = View.VISIBLE
                    player.doubleButton.visibility = View.VISIBLE
                }
                player.hitButton.visibility = View.VISIBLE
                player.standButton.visibility = View.VISIBLE
                player.splitButton.visibility = View.VISIBLE

            } else {
                var betCheck = betArray.sum() + betArray[hn]
                if (betCheck < player.balance) {
                    player.doubleButton.visibility = View.VISIBLE
                }

                player.hitButton.visibility = View.VISIBLE
                player.standButton.visibility = View.VISIBLE
                player.splitButton.visibility = View.VISIBLE
            }
        } else {
            player.doubleButton.visibility = View.GONE
//            Should be GONE, but leaving in for testing
            player.splitButton.visibility = View.VISIBLE
            player.hitButton.visibility = View.VISIBLE
            player.standButton.visibility = View.VISIBLE
        }
    }

    fun dealerHit(player: GameFragment, deck: MutableList<Card>) {
//        Makes dealer hit until she busts, or is 17/higher
//
        this.initialize(0)

        this.dealing = true
        while (this.dealing) {
            for (x in this.handTotal[0]) {
                if (x == 17) {
                    for (y in this.handTotal[0]) {
                        if (y < 17) {
                            break
                        } else {
                            this.dealerbust = false
                            return
                        }
                    }
                } else if (x > 16) {
                    this.dealerbust = false
                    return
                }
            }

            this.hit(deck, 0)
            this.moveTick(0)

//            println("Dealer draws ${this.handArray[0].last().rank} of ${this.handArray[0].last().suit}")
            this.checkDealerBust()
        }
    }

    fun checkDealerBust() {
        if (this.handArray[0].last().faceVal == 1) {
            for (i in 0 until (this.handTotal[0].size)) {
                this.handTotal[0].add(this.handTotal[0][i] + 10)
            }
            for (i in 0 until (this.handTotal[0].size)) {
                this.handTotal[0][i] = (this.handTotal[0][i] + 1)
            }
        } else {
            for (i in 0 until (this.handTotal[0].size)) {
                this.handTotal[0][i] += this.handArray[0].last().faceVal
            }
        }


        val handTotal = mutableListOf<Int>()
        this.handTotal2[0].clear()
        for (x in this.handTotal[0]) {
            this.handTotal2[0].add(x)
            if (x <= 21) {
                handTotal.add(x)
            }
        }

        if (handTotal.size == 0) {
            this.dealing = false
            this.dealerbust = true
        } else {
            this.handTotal[0].clear()
            for (x in handTotal) {
                this.handTotal[0].add(x)
            }
//            println("Dealer hand total is ${this.handTotal[0]}")
            this.dealing = true
            this.dealerbust = false
        }
        return

    }

    fun split(deck: MutableList<Card>, hn: Int) {
//        Sets up the hand array with the new split cards
        this.handArray.add(mutableListOf<Card>())
        this.handTotal.add(mutableListOf<Int>())
        this.handTotal2.add(mutableListOf<Int>())
        this.moveCount.add(0)
        this.betArray.add(this.betArray[hn])
//        println("You have chosen to split!")
        this.handArray.last().add(this.handArray[hn].removeAt(1))
        this.hit(deck, hn)
        this.hit(deck, this.handArray.size - 1)
    }

}




