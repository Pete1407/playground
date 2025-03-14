package com.example.playgroundspace.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun VerticalGrid(
    modifier: Modifier,
    composableList: List<@Composable () -> Unit>,
    itemsPerRow: Int,
    verticalSpace: Dp,
    horizontalSpace: Dp
) {
    val components = composableList.toMutableList()
    Column(
        modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(verticalSpace)
    ) {
        while (components.isNotEmpty()) {
            val rowComponents: List<@Composable () -> Unit> = components.take(itemsPerRow) // 4
            val listOfSpacers: List<@Composable () -> Unit> =
                listOfSpacers(itemsPerRow - rowComponents.size)
            RowWithItems(
                items = rowComponents.plus(listOfSpacers),
                horizontalSpace = horizontalSpace
            )
            components.removeAll(rowComponents)
        }
    }
}

private fun listOfSpacers(number: Int): List<@Composable () -> Unit> {
    val mutableList = emptyList<@Composable () -> Unit>().toMutableList()
    repeat(number) {
        mutableList.add { Spacer(Modifier) }
    }
    return mutableList.toList()
}

@Composable
private fun RowWithItems(
    items: List<@Composable () -> Unit>,
    horizontalSpace: Dp
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(horizontalSpace)
    ) {
        items.forEach { item ->
            Box(Modifier.weight(1f)) {
                item()
            }
        }
    }
}