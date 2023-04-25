package pe.edu.superherocompose.ui.screens.superheroes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
    val superHeroes by viewModel.superHeroes.observeAsState(listOf())

    LazyColumn() {
        items(superHeroes){superHero ->
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