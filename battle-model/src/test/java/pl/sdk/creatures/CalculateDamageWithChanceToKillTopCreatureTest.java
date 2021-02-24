//package pl.sdk.creatures;
//
//import com.google.common.collect.Range;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.Random;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//public class CalculateDamageWithChanceToKillTopCreatureTest {
//
//
//    private Creature attacker;
//    private Creature defender;
//    private Random rand;
//
//        @Test
//        void CheckDamageGivenToDefender() {
//            rand = mock(Random.class);
//            when(rand.nextInt(anyInt())).thenReturn(0);
//            attacker = new Creature.Builder()
//                    .statistic(CreatureStatistic.TEST)
//                    .amount(1)
//                    .build();
//            defender = new Creature.Builder()
//                    .statistic(CreatureStatistic.TEST)
//                    .amount(1)
//                    .build();
//
//            when(rand.nextDouble()).thenReturn(0.09);
//            CalculateDamageStrategy calculator = new CalculateDamageWithChanceToKillTopCreatureStrategy(10, rand);
//            int damage = calculator.calculateDamage(attacker, defender);
//            assertEquals(12,damage);
//        }
//
//        @Test
//    void CheckDamageGivenToDefenderWithDifferentAmount() {
//            rand = mock(Random.class);
//            when(rand.nextInt(anyInt())).thenReturn(0);
//            attacker = new Creature.Builder()
//                    .statistic(CreatureStatistic.TEST)
//                    .amount(13)
//                    .build();
//            defender = new Creature.Builder()
//                    .statistic(CreatureStatistic.TEST)
//                    .amount(1)
//                    .build();
//
//            when(rand.nextDouble()).thenReturn(0.09);
//            CalculateDamageStrategy calculator = new CalculateDamageWithChanceToKillTopCreatureStrategy(0.1, rand);
//            int damage = calculator.calculateDamage(attacker, defender);
//            assertEquals(46,damage);
//
//        }
//
//
//
//}
