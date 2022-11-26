package com.example.tictactoe

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.HandlerCompat.postDelayed
import androidx.databinding.DataBindingUtil
import com.example.tictactoe.databinding.FragmentGameplayBinding
import kotlin.system.exitProcess


lateinit var gbiding:FragmentGameplayBinding
var playerTurn= true
class gameplay : Fragment() {



    var player1TV:TextView= gbiding.idTVPlayer1
     var player2TV :TextView= gbiding.idTVPlayer2
    lateinit var box1btn: Button
    lateinit var box2btn: Button
    lateinit var box3btn: Button
    lateinit var box4btn: Button
    lateinit var box5btn: Button
    lateinit var box6btn: Button
    lateinit var box7btn: Button
    lateinit var box8btn: Button
    lateinit var box9btn: Button

    var player1count=0
    var player2count=0
  //
    var player1 =ArrayList<Int>()
    var player2= ArrayList<Int>()
    var emptyCells= ArrayList<Int>()
    var activeUser= 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            gbiding =DataBindingUtil.inflate(inflater,R.layout.fragment_gameplay,container,false)


        //player1TV.text=" "
       // player2TV.text= " "
        return gbiding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gbiding.idresetbtn.setOnClickListener{view:View->
            reset()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun reset() {
        player1.clear()
        player2.clear()
        emptyCells.clear()
        activeUser=1


        for (i in 1..9)
        {


            var buttonSelected:Button?
            buttonSelected= when(i)
            {
                1-> gbiding.idBtnBox1
                2-> gbiding.idBtnBox2
                3-> gbiding.idBtnBox3
                4-> gbiding.idBtnBox4
                5-> gbiding.idBtnBox5
                6-> gbiding.idBtnBox6
                7-> gbiding.idBtnBox7
                8-> gbiding.idBtnBox8
                9-> gbiding.idBtnBox9
                else->{



                    gbiding.idBtnBox1
                }
            }

            buttonSelected.isEnabled=true
            buttonSelected.text= ""

            player1TV.text= "Player 1: $player1count"
            player2TV.text= "Player 2:$player2count"
        }}
        fun buttonDisable() {

            player1.clear()
            player2.clear()
            emptyCells.clear()
            activeUser=1
            for (i in 1..9)
            {


                var buttonSelected:Button?
                buttonSelected= when(i)
                {
                    1-> gbiding.idBtnBox1
                    2-> gbiding.idBtnBox2
                    3-> gbiding.idBtnBox3
                    4-> gbiding.idBtnBox4
                    5-> gbiding.idBtnBox5
                    6-> gbiding.idBtnBox6
                    7-> gbiding.idBtnBox7
                    8-> gbiding.idBtnBox8
                    9-> gbiding.idBtnBox9
                    else->{



                        gbiding.idBtnBox1
                    }
                }

                buttonSelected.isEnabled=true
                buttonSelected.text= ""

                player1TV.text="Player 1: $player1count"
                player2TV.text= "Player 2:$player2count"
            }

        }

        fun disableReset() {
                gbiding.idresetbtn.isEnabled= false
                Handler().postDelayed({ gbiding.idresetbtn.isEnabled=true},2700)
        }

        fun checkWinner(): Int {

           // val audio = MediaPlayer.create(getActivity(), R.raw.uiwin)

            if ((player1.contains(1) && player1.contains(2) && player1.contains(3)) ||
                (player1.contains(1) && player1.contains(4) && player1.contains(7)) ||
                (player1.contains(3) && player1.contains(6) && player1.contains(9)) ||
                (player1.contains(7) && player1.contains(8) && player1.contains(9)) ||
                (player1.contains(1) && player1.contains(5) && player1.contains(9)) ||
                (player1.contains(3) && player1.contains(5) && player1.contains(7)) ||
                (player1.contains(4) && player1.contains(5) && player1.contains(6)) ||
                (player1.contains(2) && player1.contains(5) && player1.contains(8))
            ) {
                player1count += 1
                //audio.start()
                buttonDisable()

                disableReset()
                //Handler().postDelayed({ audio.release() }, 4000)

                val build = AlertDialog.Builder(context)
                build.setTitle("GAme Over")
                build.setMessage("Player  1 wins!! Do you want to paly again")
                build.setPositiveButton("ok") { dialog, which ->
                    reset()
                   // audio.release()
                }
                build.setNegativeButton("ok") { dialog, which ->
                   // audio.release()
                    exitProcess(1)

                }
                Handler().postDelayed({ build.show() }, 2000)
                return 1
            } else if ((player2.contains(1) && player2.contains(2) && player2.contains(3)) ||
                (player2.contains(1) && player2.contains(4) && player2.contains(7)) ||
                (player2.contains(3) && player2.contains(6) && player2.contains(9)) ||
                (player2.contains(7) && player2.contains(8) && player2.contains(9)) ||
                (player2.contains(1) && player2.contains(5) && player2.contains(9)) ||
                (player2.contains(3) && player2.contains(5) && player2.contains(7)) ||
                (player2.contains(4) && player2.contains(5) && player2.contains(6)) ||
                (player2.contains(2) && player2.contains(5) && player2.contains(8))
            ) {

                player2count += 1
                //audio.start()
                buttonDisable()
                disableReset()
                //andler().postDelayed({ audio.release() }, 4000)

                val build = AlertDialog.Builder(context)
                build.setTitle("GAme Over")
                build.setMessage("Player  2 wins!! Do you want to paly again")
                build.setPositiveButton("ok") { dialog, which ->
                    reset()
                   // audio.release()

                }



                build.setNegativeButton("ok") { dialog, which ->
                    //audio.release()
                    exitProcess(1)

                }
                Handler().postDelayed({ build.show() }, 2000)
                return 1
            } else if (emptyCells.contains(1) && emptyCells.contains(2) && emptyCells.contains(3) && emptyCells.contains(4)
                && emptyCells.contains(5) && emptyCells.contains(6) && emptyCells.contains(7) && emptyCells.contains(8)
                && emptyCells.contains(9)) {
                val build = AlertDialog.Builder(this.context)
                build.setTitle("GAme Over")
                build.setMessage("Game Draw! Do you want to paly again")
                build.setPositiveButton("ok") { dialog, which ->
                    reset()

                }

                build.setNegativeButton("ok") { dialog, which ->

                    exitProcess(1)

                }
                build.show()
                return 1

            }
            return 0
        }
    fun robot() {
        // This function automatically make a move at a random position.
            val rnd = (1..9).random()
            if(emptyCells.contains(rnd))
                robot()
            else {
                val buttonselected : Button?
                buttonselected = when(rnd) {
                    1 -> gbiding.idBtnBox1
                    2 -> gbiding.idBtnBox2
                    3 -> gbiding.idBtnBox3
                    4 -> gbiding.idBtnBox4
                    5 -> gbiding.idBtnBox5
                    6 -> gbiding.idBtnBox6
                    7 -> gbiding.idBtnBox7
                    8 -> gbiding.idBtnBox8
                    9 -> gbiding.idBtnBox9
                    else -> {
                        gbiding.idBtnBox1}
                }
                emptyCells.add(rnd);
                // move audio
               // val audio = MediaPlayer.create(getActivity(), R.raw.uiwin)
                //audio.start()
                //Handler().postDelayed(Runnable { audio.release() } , 500)
                buttonselected.text = "O"
                buttonselected.setTextColor(Color.parseColor("#D22BB804"))
                player2.add(rnd)
                buttonselected.isEnabled = false
                var checkWinner = checkWinner()
                if(checkWinner == 1)
                    Handler().postDelayed(Runnable { reset() } , 2000)
            }


    }

        fun playeNow(buttonSelected: Button, currCell: Int) {
           // var audio= MediaPlayer.create(getActivity(),R.raw.uiclick)
            if(activeUser==1)
            {
                buttonSelected.text= "X"
                buttonSelected.setTextColor(Color.parseColor("#EC8CBC"))
                player1.add(currCell)
                emptyCells.add(currCell)
                buttonSelected.isEnabled=false
               // audio.start()
               // Handler().postDelayed({audio.release()},200)
                val checkWinner= checkWinner()
                if(checkWinner==1)
                {
                    Handler().postDelayed({reset()},2000)
                }
                else if(singleUser)
                {
                    Handler().postDelayed({robot()},500)
                }
                else
                {
                    activeUser= 2
                }
            }
            else
            {
                buttonSelected.text= "O"
                //audio.start()
                buttonSelected.setTextColor(Color.parseColor("D22BB888"))
                activeUser=1
                player2.add(currCell)
                emptyCells.add(currCell)
                //Handler().postDelayed( {audio.release()},200)
                buttonSelected.isEnabled= false


                val checkWinner= checkWinner()
                if (checkWinner==1){
                    Handler().postDelayed( {reset()},4000)
                }
            }
        }

        //
        fun buttonClick(view:View)
        {
            if(playerTurn){
                val but = view as Button
                var cellID= 0
                when(but.id)
                {
                    R.id.idBtnBox1-> cellID=1
                    R.id.idBtnBox2-> cellID=2
                    R.id.idBtnBox3-> cellID=3
                    R.id.idBtnBox4-> cellID=4
                    R.id.idBtnBox5-> cellID=5
                    R.id.idBtnBox6-> cellID=6
                    R.id.idBtnBox7-> cellID=7
                    R.id.idBtnBox8-> cellID=8
                    R.id.idBtnBox9-> cellID=9

                }
                playerTurn= false
                Handler().postDelayed({ playerTurn=true},600)
                playeNow(but,cellID)
            }
        }


    }



