package pl.sdk;

import com.google.common.collect.Range;

public class NecropolisFactory {

    public Creature create(String aName){
        switch (aName){
            case "Skeleton":
                return new Creature.Builder()
                        .name("Skeleton")
                        .maxHp(6)
                        .attack(5)
                        .armor(4)
                        .damage(Range.closed(1,3))
                        .moveRange(4)
                        .amount(70)
                        .build();
            case "Walking Dead":
                return new Creature.Builder()
                        .name("Walking Dead")
                        .maxHp(15)
                        .attack(5)
                        .armor(5)
                        .damage(Range.closed(2,3))
                        .moveRange(3)
                        .amount(60)
                        .build();
            case "Wight":
                return new Creature.Builder()
                        .name("Wight")
                        .maxHp(18)
                        .attack(7)
                        .armor(7)
                        .damage(Range.closed(3,5))
                        .moveRange(5)
                        .amount(50)
                        .build();
            case "Vampire":
                return new BlockCounterAttackCreatureDecorator.Builder()
                        .name("Vampire")
                        .maxHp(30)
                        .attack(10)
                        .armor(9)
                        .damage(Range.closed(5,8))
                        .moveRange(6)
                        .amount(40)
                        .build();
            case "Lich":
                return new ShootingCreatureDecorator.Builder()
                        .name("Lich")
                        .maxHp(30)
                        .attack(13)
                        .armor(10)
                        .damage(Range.closed(11,13))
                        .moveRange(6)
                        .amount(30)
                        .build();
            case "Black Knight":
                return new Creature.Builder()
                        .name("Black Knight")
                        .maxHp(120)
                        .attack(16)
                        .armor(16)
                        .damage(Range.closed(15,30))
                        .damageCalculator(new CalculateDamageIncreaseWithRandomChanceStrategy(0.2,2.0))
                        .moveRange(7)
                        .amount(20)
                        .build();
            case "Bone Dragon":
                return new Creature.Builder()
                        .name("Bone Dragon")
                        .maxHp(150)
                        .attack(17)
                        .armor(15)
                        .damage(Range.closed(25,50))
                        .moveRange(9)
                        .amount(10)
                        .build();
            case "Skeleton Warrior":
                return new Creature.Builder()
                        .name("Skeleton Warrior")
                        .maxHp(6)
                        .attack(6)
                        .armor(6)
                        .damage(Range.closed(1,3))
                        .moveRange(5)
                        .amount(75)
                        .build();
            case "Zombie":
                return new Creature.Builder()
                        .name("Zombie")
                        .maxHp(20)
                        .attack(5)
                        .armor(5)
                        .damage(Range.closed(2,3))
                        .moveRange(4)
                        .amount(65)
                        .build();
            case "Wraith":
                return new RegenerationOnEndOfTurnCreatureDecorator(new Creature.Builder()
                        .name("Wraith")
                        .maxHp(20)
                        .attack(5)
                        .armor(5)
                        .damage(Range.closed(2,3))
                        .moveRange(4)
                        .amount(65)
                        .build());
            case "Vampire Lord":
                return new Creature.Builder()
                        .name("Vampire Lord")
                        .maxHp(40)
                        .attack(10)
                        .armor(10)
                        .damage(Range.closed(5,8))
                        .moveRange(9)
                        .amount(45)
                        .build();
            case "Power Lich":
                 Creature c = new Creature.Builder()
                        .name("Power Lich")
                        .maxHp(40)
                        .attack(13)
                        .armor(10)
                        .damage(Range.closed(11,15))
                        .moveRange(7)
                        .amount(35)
                        .build();
                return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(c));
            case "Dread Knight":
                return new Creature.Builder()
                        .name("Dread Knight")
                        .maxHp(120)
                        .attack(18)
                        .armor(18)
                        .damage(Range.closed(15,30))
                        .damageCalculator(new CalculateDamageIncreaseWithRandomChanceStrategy(0.2,2.0))
                        .moveRange(9)
                        .amount(25)
                        .build();
                case "Ghost Dragon":
                return new Creature.Builder()
                        .name("Bone Dragon")
                        .maxHp(200)
                        .attack(19)
                        .armor(17)
                        .damage(Range.closed(25,50))
                        .moveRange(14)
                        .amount(15)
                        .build();
            default:
                throw new IllegalArgumentException("Cannot recognize creature: " + aName);
        }
    }
}
