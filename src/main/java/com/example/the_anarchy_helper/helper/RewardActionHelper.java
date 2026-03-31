package com.example.the_anarchy_helper.helper;

import org.springframework.stereotype.Component;
@Component
public class RewardActionHelper {

    //Patrons
    private final String BUILD_CASTLE = "Build the Gates, Towers or Walls of my castle.";
    private final String BUY_PATRONS_FROM_ALLIES_MERCENARIES = "Buy Patrons from the Allies and Mercenaries quadrants of the Wealth Wheel";
    private final String BUILD_CHAPEL = "Build and pay all tithes in each Chapel level";
    private final String EXTRA_STRENGTH = "Overwhelm by 4 strength to earn an extra Patron";

    //Soldiers
    private final String CONVERT_SOLDIERS = "Convert to soldiers (and soldier production) in the Training grounds";
    private final String START_WARCRAFT_LEADERSHIP = "Start the Warcraft Leadership row for a soldier";
    private final String BUY_SOLDIERS_FROM_MERCENARIES = "Buy Soldiers from the Mercenaries quadrant of the Wealth wheel.";
    private final String FILL_RAMPARTS = "Fill in the Ramparts line in the Leadership row (and Soldier production)";
    private final String BUILD_TACTICS_FROM_WARCRAFT = "Build Tactics from the Warcraft Leadership line for a soldier";
    private final String BUILD_SIEGE_TOWER = "Build the Siege Tower or Trebuchet";
    private final String CREATE_KNIGHTS_AT_KNIGHTS_TRAINING = "Create Knights at the Knight’s Training area in the Worship row";
    private final String SCORE_BONUS_SOLDIERS = "Score bonus Soldiers";

    //Knights
    private final String USE_KNIGHT_TRAINING = "Use Knights Training on the Worship Leadership row";
    private final String GET_KNIGHT_FROM_GOVERNANCE = "A Knight can be found on the Governance Leadership line.";
    private final String GET_FROM_WARCRAFT = "A Knight and Knight production can be found at the end of the Warcraft Leadership line";
    private final String BUILD_KEEPS = "Build Keeps in the Governance Leadership line";

    //Serfs
    private final String BUY_FROM_SIEGECRAFT = "Buy them from the Siegecraft quadrant of the Wealth wheel.";
    private final String USE_VALENTINE_FESTIVAL ="Use the St. Valentine’s Festival area in the Worship Leadership row.";
    private final String GET_FROM_GOVERNANCE_AND_ENTERTAINMENT  ="Serfs and Serf production can be found on the Governance and Entertainment Leadership lines.";
    private final String SCORE_BONUS_SERFS ="Score bonus Serfs";
    private final String GAIN_A_SERF_AFTER_ATTACK ="For every 3 strength remaining after resolving all attacks, gain a Serf for the next round.";

    //Craftsmen
    private final String BUY_FROM_GUILDSMEN = "Buy them from the Guildsmen quadrant of the Wealth wheel (or one craftsman in the Allies quadrant). Note: There are Craftsmen production at the end of the Guildsmen ‘tree’.";
    private final String CRAFTSMAN_IN_LEADERSHIP_LINES = "A Craftsman can be found in every Leadership line.";
    private final String EXTRA_CRAFTSMAN_OVERWHELM = "Overwhelm by 4 strength to earn an extra Craftsman.";

    //Food
    private final String CONVERT_AT_FARMS = "Convert to Food (and Food production) at the Farms.";
    private final String FOOD_IN_WORSHIP_ENTERTAINMENT = "Food can be found in the Worship and Entertainment Leadership lines.";
    private final String BUILD_KEEP_FOOD = "Build the Keep in the Governance Leadership line and choose Food";
    private final String MICHAELMAS_FOOD = "Use the Michaelmas area in the Entertainment row and choose Food.";
    private final String EXTRA_FOOD_OVERWHELM = "Overwhelm by 2 strength to earn extra Food.";

    //Materials
    private final String CONVERT_AT_QUARRY_FOREST = "Convert to Materials (and Material production) at the Quarry & Forest.";
    private final String BUILD_CASTLE_MOAT = "Build the Castle Moat.";
    private final String MATERIALS_IN_LEADERSHIP_LINES = "Materials can be found on the Governance, Warcraft & Entertainment Leadership lines.";
    private final String BUILD_KEEP_MATERIALS = "Build the Keep in the Governance Leadership line and choose Materials.";
    private final String MICHAELMAS_MATERIALS = "Use the Michaelmas area in the Entertainment row and choose Materials";
    private final String EXTRA_MATERIAL_OVERWHELM = "Overwhelm by 3 strength to earn extra Material.";

    //Silver
    private final String SILVER_IN_LEADERSHIP_LINES = "Silver can be found on the Governance, Worship and Entertainment Leadership lines";
    private final String BUILD_KEEPS_SILVER = "Build Keeps in the Governance Leadership line and choose Silver";
    private final String MICHAELMAS_SILVER = "Use the Michaelmas area in the Entertainment row and choose Silver.";
    private final String EXTRA_SILVER_OVERWHELM = "Overwhelm by 3 strength to earn extra Silver.";

    //common
    private final String RUN_TOURNAMENTS = "Run Tournaments in the Entertainment row"; //for knights and soldiers
    private final String SCORE_BONUS_PATRONS = "Score bonus Patrons";  // for Patrons and Craftsmen
    private final String FILL_STABLES = "Fill the stables"; //for knights, Silver, Food
}