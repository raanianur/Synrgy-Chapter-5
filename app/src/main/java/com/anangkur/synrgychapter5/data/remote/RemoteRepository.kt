package com.anangkur.synrgychapter5.data.remote

import com.anangkur.synrgychapter5.domain.Movie
import com.anangkur.synrgychapter5.domain.repository.HomeRepository
import kotlinx.coroutines.delay

class RemoteRepository : HomeRepository {
    override suspend fun fetchMovies(): List<Movie> {
        delay(1000)
        return listOf(
            Movie(
                id = 961268,
                backdropPath = "/oE7xtGDqZnr7tFHfwb8oM9iRW6H.jpg",
                originalTitle = "발레리나",
                overview = "Grieving the loss of a best friend she couldn't protect, an ex-bodyguard sets out to fulfill her dear friend's last wish: sweet revenge.",
            ),
            Movie(
                id = 606403,
                backdropPath = "/lonLErm7OcVR8gnc1t2kRwuuxDm.jpg",
                originalTitle = "특송",
                overview = "A black-market cabbie drives criminals at breakneck speeds until she is left in charge of a fugitive's son.",
            ),
            Movie(
                id = 492008,
                backdropPath = "/5lmhjGvg5ddXbTXzeNJfU4qpIeh.jpg",
                originalTitle = "검객",
                overview = "After being blinded in a coup against the king, Joseon's greatest swordsman goes into hiding, far removed from his city's anguish. But when traffickers kidnap his daughter, he has no choice but to unsheathe his sword once more.",
            )
        )
    }
}