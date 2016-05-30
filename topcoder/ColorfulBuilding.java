import java.util.*;

public class ColorfulBuilding {
    public int count(String[] color1, String[] color2, int L) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(ColorfulBuilding.class, "test.*");
    }

	public void test0() {
		RETester.eq(count(new String[] {"aaba"}, new String[] {"aaaa"}, 3), 6);
	}

	public void test1() {
		RETester.eq(count(new String[] {"aaba"}, new String[] {"aaba"}, 4), 0);
	}

	public void test2() {
		RETester.eq(count(new String[] {"ab", "ba", "a", "aab"}, new String[] {"bb", "ba", "a", "aba"}, 5), 432);
	}

	public void test3() {
		RETester.eq(count(new String[] {
			"xxxxxxxxxxxxxxxxxxxx",
			"xxxxxxxxxxxxxxxxxxxx",
			"xxOOOOOOOOOOOOOOOOxx",
			"xxOOOOOOOOOOOOOOOOxx",
			"xxOOxxxxxxxxxxxxxxxx",
			"xxOOxxxxxxxxxxxxxxxx",
			"xxOOxxxxxxxxxxxxxxxx",
			"xxOOxxxxxxxxxxxxxxxx",
			"xxOOxxxxxxxxxxxxxxxx",
			"xxOOxxxxxxxxxxxxxxxx",
			"xxOOxxxxxxxxxxxxxxxx",
			"xxOOOOOOOOOOOOOOOOxx",
			"xxOOOOOOOOOOOOOOOOxx",
			"xxxxxxxxxxxxxxxxOOxx",
			"xxxxxxxxxxxxxxxxOOxx",
			"xxxxxxxxxxxxxxxxOOxx",
			"xxxxxxxxxxxxxxxxOOxx",
			"xxxxxxxxxxxxxxxxOOxx",
			"xxxxxxxxxxxxxxxxOOxx",
			"xxxxxxxxxxxxxxxxOOxx",
			"xxOOOOOOOOOOOOOOOOxx",
			"xxOOOOOOOOOOOOOOOOxx",
			"xxxxxxxxxxxxxxxxxxxx",
			"xxxxxxxxxxxxxxxxxxxx"},
			new String[] {
			"xxxxxxxxxxxxxxxxxxxx",
			"xxxxxxxxxxxxxxxxxxxx",
			"xxOOOOOOOOOOOOOOOOxx",
			"xxOOOOOOOOOOOOOOOOxx",
			"xxOOxxxxxxxxxxxxOOxx",
			"xxOOxxxxxxxxxxxxOOxx",
			"xxOOxxxxxxxxxxxxOOxx",
			"xxOOxxxxxxxxxxxxOOxx",
			"xxOOxxxxxxxxxxxxOOxx",
			"xxOOxxxxxxxxxxxxOOxx",
			"xxOOxxxxxxxxxxxxOOxx",
			"xxOOOOOOOOOOOOOOOOxx",
			"xxOOOOOOOOOOOOOOOOxx",
			"xxOOxxxxxxxxxxxxOOxx",
			"xxOOxxxxxxxxxxxxOOxx",
			"xxOOxxxxxxxxxxxxOOxx",
			"xxOOxxxxxxxxxxxxOOxx",
			"xxOOxxxxxxxxxxxxOOxx",
			"xxOOxxxxxxxxxxxxOOxx",
			"xxOOxxxxxxxxxxxxOOxx",
			"xxOOOOOOOOOOOOOOOOxx",
			"xxOOOOOOOOOOOOOOOOxx",
			"xxxxxxxxxxxxxxxxxxxx",
			"xxxxxxxxxxxxxxxxxxxx"},
			58), 619787617);
	}

	public void test4() {
		RETester.eq(count(new String[] {
			"SJXcabKTWeUXhwxGixFepQaQlFxrAedNAtVP",
			"gorBIkcTlOFbLDbFeElYAyAqszQdMbpxSRdE",
			"SQVHPehlNtesbJDflyGxMqvgzjXisRnqDcQO",
			"pIAEBwbmpPWCooQAujbGXFGLvXxTmExLARkf",
			"AFnWyWKVObfxDGCjTxdZaObgwdxlPKtIxaAd",
			"uznMpJVNjAofbHJjOrZeSHgSagOCUMGbvkVR",
			"LBRrDbTAyKfVnedKiRfzgRzECpcsziqaTwdo",
			"JrJHvsEVVGDkNVGqLbpxyLDPloBuNDQKnReI",
			"SSYpbjKHSCnQhuyYrVauWDHDyhAoGyecrZMv",
			"UdetQfWEUWHHuAxRSdkJOOJSixKpQXpCFZHO",
			"KXVsQbuQtIgsULOMsTvPFNUqkBldMTLCipYK",
			"hoXConjnDWQkZVtyZlwSedvdVrNWqQhGUClQ",
			"TpsvvyoXsXmQpBAGGVDrXCkodoRHQZmpoQDW",
			"csiJspzTqeFBRmPgeEtTAzfrfCGlTZqcPuyO",
			"vsPDVBJVaJmUAtDdcsKoUkPEbDmAwtZKwjjP",
			"MOfoMhMiKIvGQoeIJXHzyClWRtRuKXMqxUAF",
			"KyyUCkRBjsYvmPFFEGBqqVhIUdtvIyyLacfu",
			"BfuwfSajSlcuTzhMufHSQLudvGEGlyHsEmBD",
			"PLpIXZkdyXveTMfSvqnDGKWOZrTBMUIlZrqF",
			"dzVMCqrSLbanRJTYpDJNHAOLPSzmvSEPQJYm",
			"rAjRkrSjouJyFaCSPPLYSzqDmMoADyWAbobJ",
			"eOCBrJNoyFnGpXpxiExXcoOHnVsaEPXhPfLe",
			"XMjRksnxWssPEINhdhbiLBSYpCLtwNshFjXS",
			"HnnDeUAbuswsgsYQuAaXySLkFYUwFXwYTreM",
			"uqLnwOEGbwZZDgAAWEdLRZxFlogDmlhjhgHM",
			"NcfaQsgPQfirkYDRFrLQpySmBGfRHumKULZf",
			"mOpmmgclsxRzXskEywfryqCRyATNoJwnlHiD",
			"AnoKoKAjrasttjNlHCROnvTJMhEHlVPVoVMo",
			"yegLyIuRkkENFAjwzDoPLKjgUHHEkfzYDIpo",
			"EcxRGGfuaBXUFXkSxctJWOLmmVbvoMkWtTvV",
			"nBMkOBHgaltEVzfyGxseGhmBscfGIbxFbqRn",
			"GvkEcLtqdOofGtsbWDafVMbNdJxsffKDzSiR",
			"jhZQUVzTzalrZcebvyqPWtOUUyniBKTWdyLi",
			"ODJLQPMdjDdTlxrfGsNmBfeGYjzeXApqKDhJ",
			"vlJkWMzdVQujKdLViQClOrJXMTBkuZEasFgg",
			"FAsbuzrLVIgaryqXBfuBRAbReleXSSgEKSvt"},
			new String[] {
			"XAhlUHtfjOpOlQlowWppQcodMGUiqoLobxnD",
			"IDzGlKrHiVGdBjZxIcoxjwagbWieKvUwZrjg",
			"SkpkTVeIFeoNQzUUgmYAYskKONNZdgXxSiWd",
			"rXBGhTmqnvxkmqiutoDzPusDiOUggEFXGCzm",
			"fzrxVuTbFXunGbeEavjshmrIRlDorTuISCxn",
			"LsvIaxTkOBjcskiekmrKNNFEXqnfMNXLWqqu",
			"ekzxGIlbJPVEQPYAbTuMtZKsCiubDXDiBVzU",
			"hZuOCJxvBOYENGSFcUiKKAKfCdebutVmnyvB",
			"UveNkKRQmHnedrROQOpHJfrHjwcNLUShlDbn",
			"ptUkvbaGDryHRkYfHKLkSgVpjWCEcgazyxGK",
			"nVPYEqTTJsRPjzjfdOiULhnZPFeNcnbXaQlk",
			"IPXBXRhMQIkxpygsgbcRfMuvIcuzUPPHGOWX",
			"yWWlNyEyqZSIOXBFAybIuFpVqpvmKRaRFrAE",
			"EvBJVtHvKhjrFcmtpdBbFTdTVtXXZQKAglKT",
			"bCVjHzUvyINFkxXageZQMzCyNhcifACdJVDh",
			"lZITYcDSeIbLweyFtoMAfOQyBNupKlhcNpgo",
			"BduslNrJdWOUukYFFidEkMFaghfofpxVgvJd",
			"YrJpDZKqdjEPzdLsOQEdkcrBfNHPemXHokCW",
			"GjeUKSGjDlgKTyUGNrMQbBLxRUcgrWpkAwOD",
			"wgxTcswqdJHaDugNIRMvrhBsdDaJAssVbSRW",
			"qmVmqFEpvgGioMXDSFqEoQcDOAaUoGPEovSO",
			"KrukPlpfOhawaovCfteTSCIdLMrtImVtiMyQ",
			"ykwmxHsKMFzFHwcbyyedLvhZPnaNGqJMMCxd",
			"HUNYCXjNLQIFCLLGpCXHBCHLTxLynBxnHFbx",
			"uwjzbNbJepVFgMPUXVirxYHzExquBEtPmKju",
			"xXAxAbJePyUsVHeLytDvAxBGMRtnvCEiZZqe",
			"xMkQoIVxWPXPgaOYmDjTOXiMImVdzojERNxS",
			"dwICFwMAmdOIUxyAdXdshasnzwyhfnVWVqZJ",
			"etypXNVvSTEQvriGBZdSGmDEHhvpSqkFklCS",
			"YkxpFBCRYUueRcKaJUXVdaMoYMYEooPQVMOr",
			"DTrexDqclZNKdPuTRFHualJSFziCLPCZjpxo",
			"TfEijcAsSJPikkmBSbXMqYHAhPTcpcKVSkIX",
			"xKXHYPYMJxFpSbxltDKYuRiTkOLxpQKnXZPs",
			"YFYuvuYHfpFJcrLNIdlNfBxRnWdppsdalBkx",
			"NFTysBvNFjejdnlhRTclbcfGipNCxpFEOriY",
			"thkgVflJYmbUYbIlafNUMGePQWiZyYzYXvUR"}
			,
			1200), 396065426);
	}

// END CUT HERE
}
