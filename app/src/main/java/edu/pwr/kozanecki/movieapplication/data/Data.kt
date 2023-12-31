package edu.pwr.kozanecki.movieapplication.data
import edu.pwr.kozanecki.movieapplication.R

object Data {
    private val UntouchablesActors = listOf(
        Actor(
            "Francois",
            "Cluzet",
            "Philippe",
            R.drawable.francois_cluzet
        ),
        Actor(
            "Omar",
            "Sy",
            "Driss",
            R.drawable.omar_sy
        ),
        Actor(
            "Anne",
            "Le Ny",
            "Yvonne",
            R.drawable.anne_le_ny
        ),
        Actor(
            "Audrey",
            "Fleurot",
            "Magalie",
            R.drawable.audrey_fleurot
        ),
        Actor(
            "Clotilde",
            "Mollet",
            "Marcelle",
            R.drawable.clotilde_mollet
        )
    )

    private val ForrestGumpActors = listOf(
        Actor(
            "Tom",
            "Hanks",
            "Forrest Gump",
            R.drawable.tom_hanks
        ),
        Actor(
            "Robin",
            "Wright",
            "Jenny Curran",
            R.drawable.robin_wright
        ),
        Actor(
            "Sally",
            "Field",
            "Pani Gump",
            R.drawable.sally_field
        ),
        Actor(
            "Gary",
            "Sinie",
            "Porucznik Dan Taylor",
            R.drawable.gary_sinise
        ),
        Actor(
            "Mykelti",
            "Williamson",
            "Bubba",
            R.drawable.mykelti_williamson
        )
    )

    private val TheShawshankRedemptionActors = listOf(
        Actor(
            "Tim",
            "Robbins",
            "Andy Dufresne",
            R.drawable.tim_robbins
        ),
        Actor(
            "Morgan",
            "Freeman",
            "Red",
            R.drawable.morgan_freeman
        ),
        Actor(
            "Bob",
            "Gunton",
            "Naczelnik Samuel Norton",
            R.drawable.bob_gunton
        ),
        Actor(
            "William",
            "Sandler",
            "Heywood",
            R.drawable.william_sandler
        ),
        Actor(
            "Clancy",
            "Brown",
            "Kapitan Byron Hadley",
            R.drawable.clancy_brown
        )
    )

    private val BogowieActors = listOf(
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        ),
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        ),
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        )
    )

    private val ChlopakiNiePlaczaActors = listOf(
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        ),
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        ),
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        )
    )


    private val GladiatorActors = listOf(
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        ),
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        ),
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        )
    )

    private val ScentOfAWomanActors = listOf(
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        ),
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        ),
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        )
    )

    private val FourWeddingsAndAFunrealActors = listOf(
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        ),
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        ),
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        )
    )

    private val TheWolfOfWallStreetActors = listOf(
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        ),
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        ),
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        )
    )

    private val JokerActors = listOf(
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        ),
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        ),
        Actor(
            "Dummy",
            "Actor",
            "Goat",
            R.drawable.goat_photo
        )
    )

    val moviesList = listOf(
        Movie(
            "Nietykalni",
            "Intouchables 2011",
            R.drawable.nietykalni,
            "Sparaliżowany milioner zatrudnia do opieki młodego chłopaka z przedmieścia, który właśnie wyszedł z więzienia.",
            listOf(R.drawable.nietykalni_1, R.drawable.nietykalni_2, R.drawable.nietykalni_3, R.drawable.nietykalni_4, R.drawable.nietykalni_5, R.drawable.nietykalni_6, R.drawable.nietykalni_7, R.drawable.nietykalni_8, R.drawable.nietykalni_9),
            UntouchablesActors,
            listOf(R.raw.nietykalni_trailer, R.raw.nietykalni_2)
        ),
        Movie(
            "Forrest Gump",
            "1994",
            R.drawable.forrest_gump,
            "Historia życia Forresta, chłopca o niskim ilorazie inteligencji z niedowładem kończyn, który staje się miliarderem i bohaterem wojny w Wietnamie.",
            listOf(R.drawable.forrest_1, R.drawable.forrest_2, R.drawable.forrest_3, R.drawable.forrest_4, R.drawable.forrest_5, R.drawable.forrest_6, R.drawable.forrest_7, R.drawable.forrest_8, R.drawable.forrest_9),
            ForrestGumpActors,
            listOf(R.raw.forrest_gump_trailer)
        ),
        Movie(
            "Skazani na Shawshank",
            "The Shawshank Redemption 1994",
            R.drawable.skazani_na_shawshank,
            "Adaptacja opowiadania Stephena Kinga. Niesłusznie skazany na dożywocie bankier, stara się przetrwać w brutalnym, więziennym świecie.",
            listOf(R.drawable.skazani_1, R.drawable.skazani_2, R.drawable.skazani_3, R.drawable.skazani_4, R.drawable.skazani_5, R.drawable.skazani_6, R.drawable.skazani_7, R.drawable.skazani_8, R.drawable.skazani_9),
            TheShawshankRedemptionActors,
            listOf(R.raw.skazani_na_shawshank_trailer)
        ),
        Movie(
            "Bogowie",
            "2014",
            R.drawable.bogowie,
            "Profesor Zbigniew Religa, utalentowany kardiochirurg wierzy, że jest w stanie dokonać przeszczepu serca. Nie poddaje się mimo wielu nieudanych operacji.",
            listOf(R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo),
            BogowieActors,
            listOf()
        ),
        Movie(
            "Chłopaki nie płaczą",
            "2000",
            R.drawable.chlopaki_nie_placza,
            "Kuba, młody skrzypek, trafia w sam środek gangsterskich porachunków.",
            listOf(R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo),
            ChlopakiNiePlaczaActors,
            listOf()
        ),
        Movie(
            "Gladiator",
            "2000",
            R.drawable.gladiator,
            "Generał Maximus - prawa ręka cesarza, szczęśliwy mąż i ojciec - w jednej chwili traci wszystko. Jako niewolnik-gladiator musi walczyć na arenie o przeżycie.",
            listOf(R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo),
            GladiatorActors,
            listOf()
        ),
        Movie(
            "Zapach kobiety",
            "Scent of a Woman 1992",
            R.drawable.zapach_kobiety,
            "Niewidomy emerytowany pułkownik Frank Slade staje się najlepszym nauczycielem życia dla nieśmiałego studenta.",
            listOf(R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo),
            ScentOfAWomanActors,
            listOf()
        ),
        Movie(
            "Cztery Wesela i Pogrzeb",
            "Four Weddings and a Funeral",
            R.drawable.cztery_wesela_i_pogrzeb,
            "Charles jest częstym gościem na weselach przyjaciół. Nie zamierza się żenić do czasu, aż poznaje piękną Amerykankę.",
            listOf(R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo),
            FourWeddingsAndAFunrealActors,
            listOf()
        ),
        Movie(
            "Wilk z Wall Street",
            "The Wolf of Wall Street",
            R.drawable.wilk_z_wall_street,
            "Historia Jordana Belforta, brokera, którego błyskawiczna droga na szczyt i rozrzutny styl życia wzbudziły zainteresowanie FBI.",
            listOf(R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo),
            TheWolfOfWallStreetActors,
            listOf()
        ),
        Movie(
            "Joker",
            "2019",
            R.drawable.joker,
            "Strudzony życiem komik popada w obłęd i staje się psychopatycznym mordercą.",
            listOf(R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo, R.drawable.goat_photo),
            JokerActors,
            listOf()
        ),
    )
}