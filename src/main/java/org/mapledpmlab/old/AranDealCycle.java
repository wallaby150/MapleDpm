package org.mapledpmlab.old;

import org.mapledpmlab.old.skill.attackskill.aran.*;
import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.dealcyclesolo.SkillEvent;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.battlemage.FinishBlow;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.old.skill.buffskill.aran.AdrenalineBoost;
import org.mapledpmlab.old.skill.buffskill.aran.AdrenalineGenerator;
import org.mapledpmlab.old.skill.buffskill.aran.AdrenalineSurge;
import org.mapledpmlab.old.skill.buffskill.aran.InstallMaha;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AranDealCycle extends DealCycle {

    // 6차, 리레
    private final List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private final List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜
    private final List<Skill> dealCycle3 = new ArrayList<>();

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AdrenalineSurgeFinish());
            add(new AdvancedFinalAttackAran());
            add(new AuraWeaponDot());
            add(new Beyonder1());
            add(new Beyonder2());
            add(new Beyonder3());
            add(new BeyonderMaha());
            add(new BlizzardTempest());
            add(new BoostEndHuntersTargetingKeydown());
            add(new BoostEndHuntersTargetingWave());
            add(new BrandishMaha());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DireWolfsCurse());
            add(new FenrirCrash());
            add(new FenrirCrashIceberg());
            add(new FinalBlow());
            add(new FinalBlowAdrenaline());
            add(new FinalBlowWave());
            //add(new GatheringCatcher());
            add(new HowlingSwing1());
            add(new HowlingSwing2());
            add(new HowlingSwing3());
            add(new HowlingSwing4());
            add(new HowlingSwingWave());
            add(new InstallMahaSnowstorm());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SwingResearch());
            //add(new ZoneOfMaha());
            //add(new ZoneOfMahaContinue());
        }
    };

    private final List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new BoostEndHuntersTargetingBeforeDelay());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AdrenalineBoost());
            add(new AdrenalineGenerator());
            add(new AdrenalineSurge());
            add(new AuraWeaponBuff());
            add(new HeroesOath());
            add(new InstallMaha());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    Timestamp adrenalineEndTime = new Timestamp(-1);
    Timestamp installMahaEndTime = new Timestamp(-1);

    BeyonderMaha beyonderMaha = new BeyonderMaha();
    BrandishMaha brandishMaha = new BrandishMaha();
    DireWolfsCurse direWolfsCurse = new DireWolfsCurse();
    FenrirCrashIceberg fenrirCrashIceberg = new FenrirCrashIceberg();
    HowlingSwingWave howlingSwingWave = new HowlingSwingWave();
    InstallMahaSnowstorm installMahaSnowstorm = new InstallMahaSnowstorm();

    ArrayList<Timestamp> adrenalineStartTimeList = new ArrayList<>();
    ArrayList<Timestamp> adrenalineEndTimeList = new ArrayList<>();
    ArrayList<Timestamp> blizzardTempestStartTimeList = new ArrayList<>();
    ArrayList<Timestamp> blizzardTempestEndTimeList = new ArrayList<>();

    public AranDealCycle(Job job) {
        super(job, new AdvancedFinalAttackAran());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AdrenalineBoost adrenalineBoost = new AdrenalineBoost();
        AdrenalineGenerator adrenalineGenerator = new AdrenalineGenerator();
        AdrenalineSurge adrenalineSurge = new AdrenalineSurge();
        AdrenalineSurgeFinish adrenalineSurgeFinish = new AdrenalineSurgeFinish();
        AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
        Beyonder1 beyonder1 = new Beyonder1();
        BlizzardTempest blizzardTempest = new BlizzardTempest();
        BoostEndHuntersTargetingWave boostEndHuntersTargeting = new BoostEndHuntersTargetingWave();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        FinalBlow finalBlow = new FinalBlow();
        FinalBlowAdrenaline finalBlowAdrenaline = new FinalBlowAdrenaline();
        GatheringCatcher gatheringCatcher = new GatheringCatcher();
        HeroesOath heroesOath = new HeroesOath();
        HowlingSwing1 howlingSwing1 = new HowlingSwing1();
        InstallMaha installMaha = new InstallMaha();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SwingResearch swingResearch = new SwingResearch();
        ThiefCunning thiefCunning = new ThiefCunning();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(95.0);

        dealCycle1.add(heroesOath);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(installMaha);
        dealCycle1.add(adrenalineSurge);        // 20초
        for (int i = 0; i < 11; i++) {           // 1110
            dealCycle1.add(howlingSwing1);
        }
        dealCycle1.add(blizzardTempest);        // 990
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);          // 30
        dealCycle1.add(boostEndHuntersTargeting); // 600
        dealCycle1.add(adrenalineSurgeFinish);
        dealCycle1.add(adrenalineBoost);
        dealCycle1.add(boostEndHuntersTargeting);

        dealCycle2.add(heroesOath);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(installMaha);
        dealCycle2.add(adrenalineBoost);
        for (int i = 0; i < 11; i++) {           // 1530 13770   1680
            dealCycle2.add(beyonder1);
        }
        dealCycle2.add(blizzardTempest);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);
        dealCycle2.add(boostEndHuntersTargeting);   // 1260
        dealCycle2.add(adrenalineGenerator);
        dealCycle2.add(boostEndHuntersTargeting);

        dealCycle3.add(installMaha);
        dealCycle3.add(adrenalineBoost);
        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);
        dealCycle3.add(boostEndHuntersTargeting);

        while (getStart().before(getEnd())) {
            if (
                    getStart().after(auraWeaponBuff.getEndTime())
                            && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                auraWeaponBuff.setEndTime(new Timestamp(getStart().getTime() + auraWeaponBuff.getDuration() * 1000));
                addSkillEvent(auraWeaponBuff);
            }
            if (
                    getStart().after(mapleWorldGoddessBlessing.getEndTime())
                    && getStart().before(new Timestamp(90 * 1000))
            ) {
                mapleWorldGoddessBlessing.setEndTime(new Timestamp(getStart().getTime() + mapleWorldGoddessBlessing.getDuration() * 1000));
                addSkillEvent(mapleWorldGoddessBlessing);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                mapleWorldGoddessBlessing.setEndTime(new Timestamp(getStart().getTime() + mapleWorldGoddessBlessing.getDuration() * 1000));
                addDealCycle(dealCycle1);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle2);
            } else if (
                    cooldownCheck(dealCycle3)
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(brandishMaha)
            ) {
                addSkillEvent(brandishMaha);
            } else {
                addSkillEvent(beyonder1);
            }
        }
        sortEventTimeList();
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;
        if (getStart().before(skill.getActivateTime())) {
            return;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof InstallMaha) {
                installMahaEndTime = new Timestamp(getStart().getTime() + 50000);
            }
            if (
                    skill instanceof AdrenalineSurge
                    || skill instanceof AdrenalineBoost
            ) {
                adrenalineEndTime = new Timestamp(getStart().getTime() + 20000);
                adrenalineStartTimeList.add(new Timestamp(getStart().getTime()));
                adrenalineEndTimeList.add(new Timestamp(getStart().getTime() + 20000));
            }
            if (
                    skill instanceof RestraintRing
                    && restraintRingStartTime == null
                    && restraintRingEndTime == null
                    && fortyEndTime == null
            ) {
                restraintRingStartTime = new Timestamp(getStart().getTime());
                restraintRingEndTime = new Timestamp(getStart().getTime() + 15000);
                fortyEndTime = new Timestamp(getStart().getTime() + 40000);
            }
            if (
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
                this.getSkillEventList().removeAll(remove);
                Timestamp tmp = getStart();
                if (((AttackSkill) skill).getLimitAttackCount() == 0) {
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                    }
                }
                this.setStart(tmp);
            } else if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
                this.multiAttackProcess(skill);
            } else {
                if (
                        skill instanceof FenrirCrash
                        && getStart().before(adrenalineEndTime)
                ) {
                    addSkillEvent(fenrirCrashIceberg);
                }
                if (
                        skill instanceof HowlingSwing1
                        || skill instanceof HowlingSwing2
                        || skill instanceof HowlingSwing3
                        || skill instanceof HowlingSwing4
                ) {
                    addSkillEvent(howlingSwingWave);
                }
                if (
                        skill instanceof Beyonder1
                        || skill instanceof Beyonder2
                        || skill instanceof Beyonder3
                ) {
                    if (cooldownCheck(beyonderMaha)) {
                        getSkillEventList().add(new SkillEvent(beyonderMaha, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime())));
                        getEventTimeList().add(new Timestamp(getStart().getTime()));
                        if (getStart().before(adrenalineEndTime)) {
                            beyonderMaha.setCooldown(2.0);
                            applyCooldown(beyonderMaha);
                            beyonderMaha.setCooldown(4.0);
                        } else {
                            applyCooldown(beyonderMaha);
                        }
                    }
                }
                if (skill instanceof BlizzardTempest) {
                    blizzardTempestStartTimeList.add(new Timestamp(getStart().getTime() + 1020));
                    blizzardTempestEndTimeList.add(new Timestamp(getStart().getTime() + 20000));
                }
                if (
                        getStart().before(installMahaEndTime)
                        && cooldownCheck(installMahaSnowstorm)
                ) {
                    getSkillEventList().add(new SkillEvent(installMahaSnowstorm, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime())));
                    getEventTimeList().add(new Timestamp(getStart().getTime()));
                    applyCooldown(installMahaSnowstorm);
                }
                endTime = new Timestamp(getStart().getTime() + skill.getDelay());
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        }
        if (
                getStart().before(adrenalineEndTime)
                && skill instanceof BrandishMaha
        ) {
            brandishMaha.setCooldown(10.0);
        } else if (skill instanceof BrandishMaha) {
            brandishMaha.setCooldown(20.0);
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
            }
            for (SkillEvent se : useAttackSkillList) {
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
                for (int j = 0; j < blizzardTempestStartTimeList.size(); j++) {
                    if (
                            start.after(blizzardTempestStartTimeList.get(j))
                            && start.before(blizzardTempestEndTimeList.get(j))
                            && start.equals(se.getStart())
                            && (
                                    se.getSkill() instanceof AdrenalineSurgeFinish
                                    || se.getSkill() instanceof Beyonder1
                                    || se.getSkill() instanceof Beyonder2
                                    || se.getSkill() instanceof Beyonder3
                                    || se.getSkill() instanceof BoostEndHuntersTargetingWave
                                    || se.getSkill() instanceof BoostEndHuntersTargetingKeydown
                                    || se.getSkill() instanceof BrandishMaha
                                    || se.getSkill() instanceof FenrirCrash
                                    || se.getSkill() instanceof FinishBlow
                                    || se.getSkill() instanceof FinalBlowAdrenaline
                                    || se.getSkill() instanceof GatheringCatcher
                                    || se.getSkill() instanceof HowlingSwing1
                                    || se.getSkill() instanceof HowlingSwing2
                                    || se.getSkill() instanceof HowlingSwing3
                                    || se.getSkill() instanceof HowlingSwing4
                                    || se.getSkill() instanceof SmashSwing
                            )
                    ) {
                        totalDamage += getDireWolfsCurseDamage(new SkillEvent(direWolfsCurse, start, end), buffSkill, start, end, j);
                    }
                }
            }
        }
        for (AttackSkill as : attackSkillList) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }

    public Long getDireWolfsCurseDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end, int i) {
        Long attackDamage = 0L;
        Long attackCount = 4 + (start.getTime() - blizzardTempestStartTimeList.get(i).getTime()) / 1020;
        if (attackCount > 9) {
            attackCount = 9L;
        }
        direWolfsCurse = new DireWolfsCurse();
        direWolfsCurse.setAttackCount(attackCount);
        attackDamage += getAttackDamage(new SkillEvent(direWolfsCurse, start, end), buffSkill, start, end);
        return attackDamage;
    }

    @Override
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        boolean isAdrenaline = false;
        for (int i = 0; i < adrenalineStartTimeList.size(); i++) {
            if (
                    start.after(adrenalineStartTimeList.get(i))
                            && end.before(adrenalineEndTimeList.get(i))
            ) {
                isAdrenaline = true;
                break;
            }
        }
        for (AttackSkill as : attackSkillList) {
            if (isAdrenaline) {
                if (skillEvent.getSkill() instanceof Beyonder1) {
                    ((Beyonder1) skillEvent.getSkill()).setDamage(525.0 + 35 + 100 + 150);
                    ((Beyonder1) skillEvent.getSkill()).setAttackCount(5L + 1 + 2);
                } else if (skillEvent.getSkill() instanceof Beyonder2) {
                    ((Beyonder2) skillEvent.getSkill()).setDamage(540.0 + 35 + 100 + 150);
                    ((Beyonder2) skillEvent.getSkill()).setAttackCount(5L + 1 + 2);
                } else if (skillEvent.getSkill() instanceof Beyonder3) {
                    ((Beyonder3) skillEvent.getSkill()).setDamage(555.0 + 35 + 100 + 150);
                    ((Beyonder3) skillEvent.getSkill()).setAttackCount(5L + 1 + 2);
                } else if (skillEvent.getSkill() instanceof FenrirCrash) {
                    ((FenrirCrash) skillEvent.getSkill()).setDamage(735.0 + 100 + 150);
                    ((FenrirCrash) skillEvent.getSkill()).setAttackCount(7L + 1 + 2);
                } else if (skillEvent.getSkill() instanceof SmashSwing) {
                    ((SmashSwing) skillEvent.getSkill()).setDamage(150.0 + 5 + 21 + 200 + 100 + 100 + 300 + 150);
                    ((SmashSwing) skillEvent.getSkill()).setAttackCount(2L + 2);
                }
            }
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                this.getJob().addMainStat(buffSkill.getBuffMainStat());
                this.getJob().addSubStat(buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(buffSkill.getBuffOtherStat2());
                if (attackSkill instanceof DotAttackSkill) {
                    attackDamage = getDotDamage(attackSkill, buffSkill);
                } else {
                    attackDamage = (long) Math.floor(((getJob().getFinalMainStat()) * 4
                            + getJob().getFinalSubstat()) * 0.01
                            * (Math.floor((getJob().getAtt() + buffSkill.getBuffAttMagic())
                            * (1 + (getJob().getAttP() + buffSkill.getBuffAttMagicPer()) * 0.01))
                            + getJob().getPerXAtt())
                            * getJob().getConstant()
                            * (1 + (getJob().getDamage() + getJob().getBossDamage() + getJob().getStatXDamage() + buffSkill.getBuffDamage() + attackSkill.getAddDamage()) * 0.01)
                            * (getJob().getFinalDamage())
                            * buffSkill.getBuffFinalDamage()
                            * getJob().getStatXFinalDamage()
                            * attackSkill.getFinalDamage()
                            * getJob().getMastery()
                            * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
                            * (1 + 0.35 + (getJob().getCriticalDamage() + buffSkill.getBuffCriticalDamage()) * 0.01)
                            * (1 - 0.5 * (1 - (getJob().getProperty() + buffSkill.getBuffProperty()) * 0.01))
                            * (1 - 3.8 * (1 - buffSkill.getIgnoreDefense()) * (1 - getJob().getIgnoreDefense()) * (1 - getJob().getStatXIgnoreDefense()) * (1 - attackSkill.getIgnoreDefense()))
                    );
                }
                this.getJob().addMainStat(-buffSkill.getBuffMainStat());
                this.getJob().addSubStat(-buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(-buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(-buffSkill.getBuffOtherStat2());
                if (skillEvent.getStart().equals(start)) {
                    as.setUseCount(as.getUseCount() + 1);
                    as.setCumulativeAttackCount(as.getCumulativeAttackCount() + attackSkill.getAttackCount());
                }
                Long distance = end.getTime() - start.getTime();
                if (attackSkill.getMultiAttackInfo().size() == 0 && attackSkill.getInterval() == 0 && attackSkill.getDelay() != 0 && distance != 0) {
                    attackDamage = attackDamage / attackSkill.getDelay() * distance;
                }
                as.setCumulativeDamage(as.getCumulativeDamage() + attackDamage);
                break;
            }
            if (isAdrenaline) {
                if (skillEvent.getSkill() instanceof Beyonder1) {
                    ((Beyonder1) skillEvent.getSkill()).setDamage(525.0 + 35 + 100);
                    ((Beyonder1) skillEvent.getSkill()).setAttackCount(5L + 1);
                } else if (skillEvent.getSkill() instanceof Beyonder2) {
                    ((Beyonder2) skillEvent.getSkill()).setDamage(540.0 + 35 + 100);
                    ((Beyonder2) skillEvent.getSkill()).setAttackCount(5L + 1);
                } else if (skillEvent.getSkill() instanceof Beyonder3) {
                    ((Beyonder3) skillEvent.getSkill()).setDamage(555.0 + 35 + 100);
                    ((Beyonder3) skillEvent.getSkill()).setAttackCount(5L + 1);
                } else if (skillEvent.getSkill() instanceof FenrirCrash) {
                    ((FenrirCrash) skillEvent.getSkill()).setDamage(735.0 + 100);
                    ((FenrirCrash) skillEvent.getSkill()).setAttackCount(7L + 1);
                } else if (skillEvent.getSkill() instanceof SmashSwing) {
                    ((SmashSwing) skillEvent.getSkill()).setDamage(150.0 + 5 + 21 + 200 + 100 + 100 + 300);
                    ((SmashSwing) skillEvent.getSkill()).setAttackCount(2L);
                }
            }
        }
        return attackDamage;
    }

    @Override
    public List<SkillEvent> getOverlappingSkillEvents(Timestamp start, Timestamp end) {
        List<SkillEvent> overlappingSkillEvents = new ArrayList<>();
        for (SkillEvent skillEvent : getSkillEventList()) {
            if (
                    (skillEvent.getStart().before(end) && skillEvent.getEnd().after(start))
                    || (skillEvent.getStart().equals(start) && skillEvent.getStart().equals(skillEvent.getEnd()))
            ) {
                overlappingSkillEvents.add(skillEvent);
            }
        }
        boolean isOverdrive = false;
        for (SkillEvent skillEvent : overlappingSkillEvents) {
            if (skillEvent.getSkill() instanceof Overdrive) {
                isOverdrive = true;
                break;
            }
        }
        if (isOverdrive) {
            for (int i = 0; i < overlappingSkillEvents.size(); i++) {
                if (overlappingSkillEvents.get(i).getSkill() instanceof OverdriveDebuff) {
                    overlappingSkillEvents.remove(i);
                }
            }
        }
        return overlappingSkillEvents;
    }
}
