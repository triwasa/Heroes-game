package pl.sdk.skills;

public class Skill {

    private SkillStatistic skillStat;

    Skill(SkillStatistic skill) {
        skillStat = skill;
    }

    public String getName(){ return skillStat.getName(); }

    public String getCoreName(){
        return skillStat.getCoreName();
    }

    public int getTier(){
        return skillStat.getTier();
    }

    public String getDescription(){ return skillStat.getDescription(); }

    /*
    public void apply(Hero hero){
        List<Creature> creatures = hero.getCreatures();
        apply(creatures);
    }

    public void apply(List<Creature> creatures){
        Iterator<Creature> listIter = creatures.iterator();
        while (listIter.hasNext()){
            new Offence1CalculateDamageDecorator(listIter.next());
        }
    }

    public Creature apply(Creature creature) {
        //creature = new Offence1CalculateDamageDecorator(creature);
        return new Offence1CalculateDamageDecorator(new Offence1CalculateDamageDecorator(creature));
    }
    */

}
