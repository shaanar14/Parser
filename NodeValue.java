/*
    Author: Shaan Arora C3236359
    Enum for STNode NodeValue
 */

public enum NodeValue
{

    //TODO Reduce amount of enums?
    N0("NPROG"),   N1("NGLOB"),   N2("NILIST"),  N3("NINIT"),   N4("NFUNCS"),  N5("NMAIN"),
    N6("NSDLST"),  N7("NTYPEL"),  N8("NRTYPE"),  N9("NATYPE"),  N10("NFLIST"), N11("NSDECL"),
    N12("NALIST"), N13("NARRD"),  N14("NFUND"),  N15("NPLIST"), N16("NSIMP"),  N17("NARRP"),
    N18("NARRC"),  N20("NDLIST"), N21("NSTATS"), N22("NFOR"),   N23("NREPT"),  N24("NASGNS"),
    N25("NIFTH"),  N26("NIFTE"),  N27("NASGN"),  N28("NPLEQ"),  N29("NMNEQ"),  N30("NSTEQ"),
    N31("NDVEQ"),  N32("NINPUT"), N33("NPRINT"), N34("NPRLN"),  N35("NCALL"),  N36("NRETN"),
    N37("NVLIST"), N38("NSIMV"),  N39("NARRV"),  N40("NEXPL"),  N41("NBOOL"),  N42("NNOT"),
    N43("NAND"),   N44("NOR"),    N45("NXOR"),   N46("NEQL"),   N47("NNEQ"),   N48("NGEQ"),
    N49("NLEQ"),   N50("NLSS"),   N51("NADD"),   N52("NSUB"),   N53("NMUL"),   N54("NDIV"),
    N55("NMOD"),   N56("NPOW"),   N57("NILIT"),  N58("NFLIT") , N59("NTRUE"),  N60("NFALS"),
    N61("NFCALL"), N62("NPRLST"), N63("NSTRG");


    private final String value;

    NodeValue(String word) {this.value = word;}

    public String getNodeValue() {return this.value;}
}
