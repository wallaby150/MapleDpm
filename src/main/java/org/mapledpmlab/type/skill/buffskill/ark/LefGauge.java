package org.mapledpmlab.type.skill.buffskill.ark;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class LefGauge extends BuffSkill {
    public LefGauge() {
        this.setCooldown(1.0);
        this.setApplyCooldownReduction(false);
    }
}
