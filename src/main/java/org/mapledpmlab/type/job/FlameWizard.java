package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossBuffCritical;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.BuffFarm;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.IntUnion;

public class FlameWizard extends Job {

    public FlameWizard() {
        // 기본
        super();
        this.setName("플레임위자드");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.96 / 2);      // 숙련도
        this.setJobType(JobType.ETC);
        this.addObject(new BossBuffCritical());
        this.addObject(new BuffFarm());
        this.addObject(new HybridLogic());
        this.addObject(new Noblesse());
        this.addObject(new IntUnion());
        this.addPerXMainStat(20L);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addMagic((long) (406 + 250 + 72 + 276));
        this.setWeaponAttMagic((long) (406 + 250 + 72 + 276));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);
        this.addMagicP(3L);

        // 보조
        this.addMainStat((long) (10 + 80 + 75));
        this.addSubStat(75L);
        this.addAtt(45L);
        this.addMagic((long) (1 + 45));
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);

        // 0차
        this.addAttP(10L);              // 엘리멘탈 엑스퍼트
        this.addMagicP(10L);
        this.addMainStat(               // 엘리멘탈 하모니
                (this.getLevel() - 1) / 2
        );

        // 2차
        this.addMagic(20L);             // 북 오브 파이어
        this.addMagic(10L);             // 주문 연마

        // 3차
        this.addFinalDamage(1.25);      // 해방된 마력
        this.addCriticalP(30.0);        // 약점 분석
        this.addCriticalDamage(20.0);
        this.addMainStat(60L);          // 번뜩이는 깨달음

        // 4차
        this.addMagic(41L);             // 엘리멘트 : 플레임 IV
        this.addMagic(21L);             // 마법의 진리
        this.addFinalDamage(1.53);
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() * 4 + getFinalSubstat()) * 0.01
                        * Math.floor(this.getMagic() * (1 + this.getMagicP() * 0.01))
                        * this.getConstant()
                        * (1 + this.getDamage() * 0.01)
                        * this.getFinalDamage()
        );
    }
}
