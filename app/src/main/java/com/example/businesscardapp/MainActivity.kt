package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Box {

        Image(
            painter = painterResource(id = R.drawable.wedding),
            contentDescription = stringResource(R.string.wedding_background_description),
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .alpha(0.4f),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(72.dp))

            Column {
                BusinessOwnerImageAndTitle(
                    image = painterResource(id = R.drawable.female_photographer),
                    businessOwnerName = stringResource(R.string.business_owner_name),
                    businessOwnerTitle = stringResource(R.string.business_owner_title)
                )
            }

            Spacer(modifier = Modifier.height(216.dp))

            Column(modifier = Modifier.padding(16.dp)) {

                BusinessContactInfo(
                    icon = painterResource(id = R.drawable.phone_icon),
                    contactInfo = stringResource(R.string.business_owner_phone_number)
                )

                BusinessContactInfo(
                    icon = painterResource(id = R.drawable.instagram_icon),
                    contactInfo = stringResource(R.string.business_owner_instagram_handle)
                )

                BusinessContactInfo(
                    icon = painterResource(id = R.drawable.mail_icon),
                    contactInfo = stringResource(R.string.business_owner_email)
                )
            }

            Spacer(modifier = Modifier.height(72.dp))
        }

    }
}

@Composable
fun BusinessOwnerImageAndTitle(
    image: Painter,
    businessOwnerName: String,
    businessOwnerTitle: String
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = image,
            contentDescription = stringResource(R.string.female_photographer_image_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(156.dp, 141.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(Color(0xFFE2FFC5))
        )

        Text(
            text = businessOwnerName,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 8.dp),
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = businessOwnerTitle,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )

    }
}

@Composable
fun BusinessContactInfo(icon: Painter, contactInfo: String) {

    Row(
        modifier = Modifier
            .padding(6.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .padding(end = 8.dp)
                .size(18.dp, 16.dp),
            tint = Color.White
        )

        Text(
            text = contactInfo,
            color = Color.White,
            style = MaterialTheme.typography.labelSmall
        )
    }

}


@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun BusinessCardPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}

