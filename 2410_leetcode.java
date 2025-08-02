import java.util.*;

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0, j = 0;
        int matches = 0;

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                matches++;
                i++;
                j++;
            } else {
                j++; // trainer can't handle player, try next trainer
            }
        }

        return matches;
    }
}
