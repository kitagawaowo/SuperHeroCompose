package pe.edu.superherocompose.ui.screens.superheroes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import pe.edu.superherocompose.data.model.SuperHero

@Composable
fun SuperHeroes(viewModel: SuperHeroViewModel) {
    /*val superHeroes = remember {
        mutableStateOf(mutableListOf<SuperHero>())

    }*/
    val superHeroes by viewModel.superHeroes.observeAsState(listOf())
    val sampleUrl = "https://imgs.search.brave.com/eIV8j4C_qYV92FYPS-K_FoUhZqmczTCPcKx0y119VKs/rs:fit:735:1119:1/g:ce/aHR0cHM6Ly9pLnBp/bmltZy5jb20vNzM2/eC9hNi9kYy9hYi9h/NmRjYWJiMWY3MDE2/NDFkN2M1NjQ3YmI1/OWVjMDA5OS5qcGc"
    superHeroes.value.add (
        SuperHero(
            "Batman",
            "Bruce Wayne",
            sampleUrl
        )
    )

    LazyColumn() {
        items(superHeroes.value){superHero ->
            SuperHeroItem(superHero)

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroItem(superHero: SuperHero, modifier: Modifier = Modifier) {
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(4.dp)) {
        Row {
            SuperHeroImage(superHero)
            Spacer(modifier = modifier.width(10.dp))
            Column (modifier = modifier.weight(7f)){
                Text(text = superHero.name, fontWeight = FontWeight.Bold)
                Text(text = superHero.fullName)
            }
            IconButton(
                modifier = modifier.weight(1f),
                onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun SuperHeroImage(superHero: SuperHero, modifier: Modifier = Modifier) {
    AsyncImage(
        model = superHero.imageUrl,
        contentDescription = null,
        modifier = modifier
            .size(92.dp)
            .clip(shape = RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop
    )
}