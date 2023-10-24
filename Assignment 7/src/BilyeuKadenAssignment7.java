/*
 * Kaden Bilyeu
 * CS 1450-002 (Tuesday/Thursday)
 * Due Thursday, October 26th 1:40pm
 * Assignment 7
 * This assignment allows us to get more familiar with queues and priority queues.
 * The goal of the assignment is to manipulate a team and simulate a game using queues.
 */

public class BilyeuKadenAssignment7 
{
    public static void main(String[] args) 
    {

    }    

} // BilyeuKadenAssignment7

//-------------------start-of-EscapeRoom---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class EscapeRoom
{

//-------------------start-of-hash()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Hashes a string using the Jenkins hash function.
     * Jenkins hash function provided by the professor.
     * @param key String - the key to be hashed
     * @return int - the hash value of the key
     */

    private int hash(String key) 
    {
        int hash = 0;

        for (int i = 0; i < key.length(); i++) 
        {
            hash += key.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }

        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);

        return Math.abs(hash);
    } 

//-------------------start-of-tryToEscape()---------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    public int tryToEscape(String playerName, int playerRanking)
    {
        String keyToHash = playerName + playerRanking;
        int hashValue = hash(keyToHash);
        int score = hashValue % 101;

        return score;

    }

} // EscapeRoom
