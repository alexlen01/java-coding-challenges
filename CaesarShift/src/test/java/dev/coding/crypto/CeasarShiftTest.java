package dev.coding.crypto;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CeasarShiftTest {

    @Test
    public void testCipher() {
        CeasarShift cs = new CeasarShift();
        String msg = "WRGDB, ZH WULHG WR VROYH DQ HQFUBSWHG PHVVDJH. ZH ZHUH DEOH WR ILQG WKH OHWWHUV, EXW WKHQ ZH KDG WR JR WR OXQFK! DW OHDVW   ZH'OO EH DEOH WR ILQLVK DW VWXGB KDOO. ORYH BRX! (:";
        String res = cs.cipher(msg, -3);

        assertNotNull(res);
    }

}
