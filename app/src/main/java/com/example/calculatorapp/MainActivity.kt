package com.example.calculatorapp

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.calculatorapp.R.id.txtPlayer2Health
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    val player1Turn = "Player 1 Turn"
    val player2Turn = "Player 2 Turn"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var config = resources.configuration
        modifyLayout(config)
    }

    /**
     * this function is to find a configuration of my phone
     * @param newConfig: configuration of the application
     */
    override fun onConfigurationChanged(newConfig: Configuration){
        super.onConfigurationChanged(newConfig)
        modifyLayout(newConfig)
    }

    /**
     * this function is what figures out the orientation of my application
     * @param newConfig: the configuration of the application
     */
    private fun modifyLayout(newConfig: Configuration){
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            setContentView(R.layout.activity_main2)
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
            setContentView(R.layout.activity_main)
    }

    /**
     * change the screen to the attack screen when the user presses the attack button
     */
    fun attackScreen(view: View){
        setContentView(R.layout.attack_screen)
    }

    /**
     * This function figures out what players turn it is
     * It then uses the inputed attack and defense to calculate the attack on that player
     * if positive remove health from player
     * @param view: view that is passed in
     */
    fun attack1(view: android.view.View) {
        if(findViewById<TextView>(R.id.txtPlayerTurn).text.toString().equals("Player 1 Turn")) {
            findViewById<TextView>(R.id.txtPlayer2Health).text =
                (attackFun(
                    findViewById<TextView>(R.id.txtPlayer2Health).text.toString().toInt(),
                    findViewById<EditText>(R.id.etAttackPower).text.toString().toInt(),
                    findViewById<EditText>(R.id.etDefensePower).text.toString().toInt()
                ).toString())
        }else{
            findViewById<TextView>(R.id.txtPlayer1Health).text =
                (attackFun(
                    findViewById<TextView>(R.id.txtPlayer1Health).text.toString().toInt(),
                    findViewById<EditText>(R.id.etAttackPower).text.toString().toInt(),
                    findViewById<EditText>(R.id.etDefensePower).text.toString().toInt()
                ).toString()
            )
        }
        setContentView(R.layout.activity_main)
    }

    /**
     * helper function to calculate attack
     * if positive return that
     * if negative return 0
     * @param health: player health
     * @param attack: attack monster points
     * @param defense: defense monster points
     * @return the amount of points to take away
     */
    fun attackFun(health: Int, attack: Int, defense: Int): Int{
        if(attack - defense > 0) {
            return health - (attack - defense)
        }
        return 0
    }

    /**
     * change the player turn
     * @param view: the view that is passed in
     */
    fun nextTurn(view: android.view.View) {
        if(findViewById<TextView>(R.id.txtPlayerTurn).text.toString().equals(player1Turn)) {
            findViewById<TextView>(R.id.txtPlayerTurn).text = player2Turn
        }else{
            findViewById<TextView>(R.id.txtPlayerTurn).text = player1Turn
        }
    }

    /**
     * create a new game by changing player health back to 8000
     * @param view: the view that is passed in
     */
    fun newGame(view: android.view.View) {
        findViewById<TextView>(R.id.txtPlayer1Health).setText("8000")
        findViewById<TextView>(R.id.txtPlayer2Health).setText("8000")
    }

}