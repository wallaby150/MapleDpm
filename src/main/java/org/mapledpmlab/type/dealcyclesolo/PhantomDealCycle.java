package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.phantom.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.phantom.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PhantomDealCycle extends DealCycle {
    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new BlackJackBeforeDelay());
            add(new BlackJack());
            add(new BlackJackFinal());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DefyingFate());
            add(new DefyingFateHeroWill());
            add(new FinalCut());
            add(new JokerBeforeDelay());
            add(new Joker());
            add(new JokerAfterDelay());
            add(new Judgement());
            add(new MarkOfPhantom());
            add(new MarkOfPhantomFinal());
            add(new NoireCarte());
            add(new RiftBreak());
            add(new RoseCarteFinale());
            add(new RoseCarteFinaleDot());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new TempestOfCardBeforeDelay());
            add(new TempestOfCard());
            add(new UltimateDrive());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new BullsEyePhantom());
            add(new FinalCutBuff());
            add(new HeroesOath());
            add(new JokerHourglass());
            add(new JokerSword());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new PreparationPhantom());
            add(new ReadyToDie());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    Long cardStack = 0L;

    BlackJackBeforeDelay blackJackBeforeDelay = new BlackJackBeforeDelay();
    BlackJackFinal blackJackFinal = new BlackJackFinal();
    BullsEyePhantom bullsEye = new BullsEyePhantom();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    DefyingFate defyingFate = new DefyingFate();
    FinalCutBuff finalCutBuff = new FinalCutBuff();
    HeroesOath heroesOath = new HeroesOath();
    JokerBeforeDelay jokerBeforeDelay = new JokerBeforeDelay();
    Judgement judgement = new Judgement();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    MarkOfPhantom markOfPhantom = new MarkOfPhantom();
    MarkOfPhantomFinal markOfPhantomFinal = new MarkOfPhantomFinal();
    PreparationPhantom preparationPhantom = new PreparationPhantom();
    ReadyToDie readyToDie = new ReadyToDie();
    RestraintRing restraintRing = new RestraintRing();
    RiftBreak riftBreak = new RiftBreak();
    RingSwitching ringSwitching = new RingSwitching();
    RoseCarteFinale roseCarteFinale = new RoseCarteFinale();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    TempestOfCardBeforeDelay tempestOfCardBeforeDelay = new TempestOfCardBeforeDelay();
    UltimateDrive ultimateDrive = new UltimateDrive();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    public PhantomDealCycle(Job job) {
        super(job, new NoireCarte());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);


        ringSwitching.setCooldown(85.0);
        ringSwitching.setApplyCooldownReduction(false);
        mapleWorldGoddessBlessing.setCooldown(180.0);
        //readyToDie.setCooldown(90.0);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(finalCutBuff)
                            && cooldownCheck(heroesOath)
                            && cooldownCheck(mapleWorldGoddessBlessing)
                            && cooldownCheck(bullsEye)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(readyToDie)
                            && cooldownCheck(blackJackBeforeDelay)
                            && cooldownCheck(markOfPhantom)
                            && cooldownCheck(restraintRing)
                            && cooldownCheck(riftBreak)
                            && cooldownCheck(jokerBeforeDelay)
                            && cooldownCheck(roseCarteFinale)
                            && getStart().before(new Timestamp(600 * 1000))
            ) {
                addSkillEvent(finalCutBuff);
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(heroesOath);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(ultimateDrive);
                }
                addSkillEvent(bullsEye);
                addSkillEvent(soulContract);
                addSkillEvent(readyToDie);
                addSkillEvent(blackJackBeforeDelay);
                addSkillEvent(markOfPhantom);
                addSkillEvent(restraintRing);
                if (cooldownCheck(defyingFate)) {
                    addSkillEvent(defyingFate);
                }
                addSkillEvent(riftBreak);
                addSkillEvent(jokerBeforeDelay);
                if (cooldownCheck(blackJackBeforeDelay)) {
                    addSkillEvent(blackJackBeforeDelay);
                }
                addSkillEvent(roseCarteFinale);
            } else if (
                    cooldownCheck(finalCutBuff)
                            && cooldownCheck(preparationPhantom)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(readyToDie)
                            && cooldownCheck(blackJackBeforeDelay)
                            && cooldownCheck(markOfPhantom)
                            && cooldownCheck(weaponJumpRing)
                            && cooldownCheck(riftBreak)
                            && cooldownCheck(roseCarteFinale)
            ) {
                addSkillEvent(finalCutBuff);
                addSkillEvent(preparationPhantom);
                addSkillEvent(soulContract);
                addSkillEvent(readyToDie);
                addSkillEvent(blackJackBeforeDelay);
                addSkillEvent(markOfPhantom);
                addSkillEvent(weaponJumpRing);
                addSkillEvent(riftBreak);
                addSkillEvent(roseCarteFinale);
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(80 * 1000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(markOfPhantom)
                            && (
                            !cooldownCheck(readyToDie)
                                    || getStart().after(new Timestamp(660 * 1000))
                    )
            ) {
                addSkillEvent(markOfPhantom);
            } else if (
                    cooldownCheck(riftBreak)
                            && (
                            !cooldownCheck(readyToDie)
                                    || getStart().after(new Timestamp(660 * 1000))
                    )
            ) {
                addSkillEvent(riftBreak);
            } else if (
                    cooldownCheck(roseCarteFinale)
                            && (
                            !cooldownCheck(readyToDie)
                                    || getStart().after(new Timestamp(660 * 1000))
                    )
            ) {
                addSkillEvent(roseCarteFinale);
            } else if (
                    cooldownCheck(blackJackBeforeDelay)
                            && (
                            getStart().before(new Timestamp(readyToDie.getActivateTime().getTime() + 10000))
                                    || getStart().after(new Timestamp(660 * 1000))
                    )
            ) {
                addSkillEvent(blackJackBeforeDelay);
            } else if (cooldownCheck(tempestOfCardBeforeDelay)) {
                addSkillEvent(tempestOfCardBeforeDelay);
            } else {
                addSkillEvent(ultimateDrive);
            }
        }
        sortEventTimeList();
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName());
            return;
        }
        if (skill instanceof BuffSkill) {
            if (
                    skill instanceof RestraintRing
                    && restraintRingStartTime == null
                    && restraintRingEndTime == null
                    && fortyEndTime == null
            ) {
                restraintRingStartTime = new Timestamp(getStart().getTime());
                restraintRingEndTime = new Timestamp(getStart().getTime() + 15000);
                fortyEndTime = new Timestamp(getStart().getTime() + 40000);
            } else if (
                    skill instanceof RestraintRing
                            && restraintRingStartTime != null
                            && restraintRingEndTime != null
                            && fortyEndTime != null
                            && originXRestraintRingStartTime == null
                            && originXRestraintRingEndTime == null
            ) {
                originXRestraintRingStartTime = new Timestamp(getStart().getTime());
                originXRestraintRingEndTime = new Timestamp(getStart().getTime() + 15000);
            }
            if (((BuffSkill) skill).isApplyPlusBuffDuration()) {
                endTime = new Timestamp((long) (getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            } else {
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (((AttackSkill) skill).getInterval() != 0) {
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (
                            skillEvent.getStart().after(getStart())
                            && skillEvent.getSkill().getClass().getName().equals(skill.getClass().getName())
                    ) {
                        remove.add(skillEvent);
                    }
                }
                getSkillEventList().removeAll(remove);
                Timestamp tmp = getStart();
                if (((AttackSkill) skill).getLimitAttackCount() == 0) {
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    long i = 0;
                    if (skill instanceof BlackJack) {
                        i = 440;
                    } else {
                        i = ((AttackSkill) skill).getInterval();
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                    }
                }
                this.setStart(tmp);
            } else if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
                this.multiAttackProcess(skill);
            } else {
                if (skill instanceof JokerAfterDelay) {
                    skill = new JokerAfterDelay();
                    if (skill.getRelatedSkill() instanceof JokerHourglass) {

                    }
                }
                endTime = new Timestamp(getStart().getTime() + skill.getDelay());
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        }
        applyCooldown(skill);
        getEventTimeList().add(getStart());
        getEventTimeList().add(new Timestamp(getStart().getTime() + skill.getDelay()));
        if (endTime != null) {
            getEventTimeList().add(endTime);
        }
        getStart().setTime(getStart().getTime() + skill.getDelay());
        if (skill.getRelatedSkill() != null) {
            addSkillEvent(skill.getRelatedSkill());
        }
    }

    @Override
    public Long calcTotalDamage(List<Timestamp> eventTimeList) {
        Long totalDamage = 0L;
        Timestamp start = null;
        Timestamp end = null;
        List<SkillEvent> overlappingSkillEvents;
        BuffSkill buffSkill;
        for (int i = 0; i < eventTimeList.size() -1; i++) {
            List<SkillEvent> useAttackSkillList = new ArrayList<>();
            buffSkill = new BuffSkill();
            start = eventTimeList.get(i);
            end = eventTimeList.get(i + 1);
            overlappingSkillEvents = getOverlappingSkillEvents(start, end);
            List<SkillEvent> useBuffSkillList = new ArrayList<>();
            for (SkillEvent skillEvent : overlappingSkillEvents) {
                StackTraceElement[] stackTraceElement = new Throwable().getStackTrace();
                if (
                        stackTraceElement[1].getMethodName().equals("calcOriginXRestraintDeal")
                                && (
                                skillEvent.getSkill() instanceof CrestOfTheSolarDot
                                        || skillEvent.getSkill() instanceof SpiderInMirrorDot
                        )
                ) {
                    continue;
                }
                if (skillEvent.getSkill() instanceof BuffSkill) {
                    useBuffSkillList.add(skillEvent);
                } else {
                    useAttackSkillList.add(skillEvent);
                }
            }
            useBuffSkillList = deduplication(useBuffSkillList, SkillEvent::getSkill);
            for (SkillEvent skillEvent : useBuffSkillList) {
                buffSkill.addBuffAttMagic(((BuffSkill) skillEvent.getSkill()).getBuffAttMagic());
                buffSkill.addBuffAttMagicPer(((BuffSkill) skillEvent.getSkill()).getBuffAttMagicPer());
                buffSkill.addBuffAllStatP(((BuffSkill) skillEvent.getSkill()).getBuffAllStatP());
                buffSkill.addBuffCriticalDamage(((BuffSkill) skillEvent.getSkill()).getBuffCriticalDamage());
                buffSkill.addBuffCriticalP(((BuffSkill) skillEvent.getSkill()).getBuffCriticalP());
                buffSkill.addBuffDamage(((BuffSkill) skillEvent.getSkill()).getBuffDamage());
                buffSkill.addBuffFinalDamage(((BuffSkill) skillEvent.getSkill()).getBuffFinalDamage());
                buffSkill.addBuffIgnoreDefense(((BuffSkill) skillEvent.getSkill()).getBuffIgnoreDefense());
                buffSkill.addBuffMainStat(((BuffSkill) skillEvent.getSkill()).getBuffMainStat());
                buffSkill.addBuffMainStatP(((BuffSkill) skillEvent.getSkill()).getBuffMainStatP());
                buffSkill.addBuffOtherStat1(((BuffSkill) skillEvent.getSkill()).getBuffOtherStat1());
                buffSkill.addBuffOtherStat2(((BuffSkill) skillEvent.getSkill()).getBuffOtherStat2());
                buffSkill.addBuffProperty(((BuffSkill) skillEvent.getSkill()).getBuffProperty());
                buffSkill.addBuffSubStat(((BuffSkill) skillEvent.getSkill()).getBuffSubStat());
                for (BuffSkill bs : buffSkillList) {
                    if (
                            bs.getClass().getName().equals(skillEvent.getSkill().getClass().getName())
                                    && start.equals(skillEvent.getStart())
                    ) {
                        bs.setUseCount(bs.getUseCount() + 1);
                        bs.getStartTimeList().add(skillEvent.getStart());
                        bs.getEndTimeList().add(skillEvent.getEnd());
                    }
                }
            }
            for (SkillEvent se : useAttackSkillList) {
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                        cardStack ++;
                        if (cardStack >= 40) {
                            totalDamage += getAttackDamage(new SkillEvent(judgement, start, end), buffSkill, start, end);
                            cardStack -= 40;
                        }
                    }
                }
            }
        }
        for (AttackSkill as : getAttackSkillList()) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }
}
