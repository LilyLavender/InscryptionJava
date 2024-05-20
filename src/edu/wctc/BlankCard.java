package edu.wctc;

import edu.wctc.Cost.CostFree;
import edu.wctc.Cost.CostMethod;
import edu.wctc.Power.Power;
import edu.wctc.Power.PowerMethod;
import edu.wctc.Power.PowerNone;
import edu.wctc.Sigils.Sigil;
import edu.wctc.Tribes.Tribe;
import edu.wctc.Tribes.TribeNone;

import java.util.ArrayList;
import java.util.List;

public class BlankCard extends Card {
    public BlankCard() {
        super("", new PowerNone(), 0, new CostFree(), new TribeNone(), new ArrayList<>());
    }
}
