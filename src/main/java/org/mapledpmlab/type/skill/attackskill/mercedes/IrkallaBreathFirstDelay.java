package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IrkallaBreathFirstDelay extends AttackSkill {
    public IrkallaBreathFirstDelay() {
        this.setName("이르칼라의 숨결(선딜)");
        this.setDelay(720L);
        this.setCooldown(180.0);
        this.setRelatedSkill(new IrkallaBreath());
    }
}
