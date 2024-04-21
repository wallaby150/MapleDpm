package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.artifact.Artifact;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.LukUnion;

import java.util.stream.Collectors;

public class Xenon extends Job {
    private Long starforce = 0L;

    public Xenon() {
        // 기본
        super();
        this.setName("제논");
        this.setConstant(1.5);          // 무기상수
        this.setMainStat(               // 기본 스탯(275 기준)
                this.getLevel() * 5 + 18 - 326 - 326
        );
        this.setSubStat(330L);          // STR
        this.setOtherStat1(330L);       // DEX
        this.addMainStat((long) (4 + 5 + 30 + 6 + 6 + 6 + 6));
        this.addSubStat((long) (4 + 5 + 30 + 6 + 6 + 6 + 6));
        this.addOtherStat1((long) (4 + 5 + 30 + 6 + 6 + 6 + 6));
        this.setMastery(1.86 / 2);      // 숙련도
        this.addMainStat(30L);          // 향상된 10단계 물약
        this.setJobType(JobType.XENON);

        this.addPerXMainStat(-28200L);
        this.addPerXMainStat(7200L + 6366);
        this.addPerXSubStat(7200L + 6366);
        this.addPerXOtherStat(7200L + 6366);
        this.addPerXMainStat((long) (144 * 4 + 96 * 20));

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addAtt((long) (255 + 157 + 72 + 223));
        this.setWeaponAttMagic((long) (255 + 157 + 72 + 223));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);
        this.addAttP(3L);

        // 보조
        this.addMainStat(2L);
        this.addSubStat(2L);
        this.addOtherStat1(2L);
        this.addOtherStat2(2L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);
        
        // 0차
        this.addDamage(3L);             // 멀티래터럴 I
        this.addMainStat(70L);          // 컨버전 스타포스
        this.addSubStat(70L);
        this.addOtherStat1(70L);

        // 1차
        this.addAtt(30L);               // 인클라인 파워
        this.addDamage(5L);             // 멀티래터럴 II

        // 2차
        this.addCriticalP(40.0);        // 리니어 퍼스펙티브
        this.addMainStat(25L);          // 마이너리티 서포트
        this.addSubStat(25L);
        this.addOtherStat1(25L);
        this.addAtt(20L);               // 제논 마스터리
        this.addDamage(7L);             // 멀티래터럴 III

        // 3차
        this.addMainStat(10L);          // 듀얼브리드 디펜시브
        this.addSubStat(10L);
        this.addOtherStat1(10L);
        this.addDamage(10L);            // 멀티래터럴 IV

        // 4차
        this.addMainStat(               // 메이플 용사
                (long) Math.floor(
                        ((this.getLevel() + 2) * 5 - 326 - 326) * 0.16
                )
        );
        this.addSubStat((long) Math.floor(326 * 0.16));
        this.addOtherStat1((long) Math.floor(326 * 0.16));
        this.addAtt(31L);               // 제논 엑스퍼트
        this.addCriticalDamage(8.0);
        this.addIgnoreDefenseList(31L);  // 오펜시브 매트릭스
        this.addDamage(10L);            // 멀티래터럴 V
        this.addDamage(5L);             // 멀티래터럴 VI
        this.addFinalDamage(1.15);

        // 5차
        this.addAtt(40L);               // 로디드 다이스
        this.addAtt(30L);               // 레디 투 다이

        this.setAbility(new BossCriticalAbnormal());
        this.setArtifact(new Artifact());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new LukUnion());
        this.addPerXMainStat(10L);
        this.addPerXSubStat(10L);
        this.addPerXOtherStat(10L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    public Long getFinalSubStat2() {
        return (long) Math.floor(
                (this.getOtherStat1()
                * (1 + this.getAllStatP() * 0.01))
                + this.getPerXOtherStat());
    }

    public Long getStrDex() {
        return getFinalSubstat() + getFinalSubStat2();
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() + getStrDex()) * 4 * 0.01
                        * Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                        * this.getConstant()
                        * (1 + this.getDamage() * 0.01)
                        * this.getFinalDamage()
        );
    }
}
