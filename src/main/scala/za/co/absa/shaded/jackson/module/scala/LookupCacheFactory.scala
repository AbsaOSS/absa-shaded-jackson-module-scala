package za.co.absa.shaded.jackson.module.scala

import za.co.absa.shaded.jackson.databind.util.{LRUMap, LookupCache}

/**
 * Factory for creating [[za.co.absa.shaded.jackson.databind.util.LookupCache]] instances
 *
 * @since 2.14.3
 */
trait LookupCacheFactory {
  def createLookupCache[K, V](initialEntries: Int, maxEntries: Int): LookupCache[K, V]
}

object DefaultLookupCacheFactory extends LookupCacheFactory {
  override def createLookupCache[K, V](initialEntries: Int, maxEntries: Int): LookupCache[K, V] = {
    new LRUMap[K, V](initialEntries, maxEntries)
  }
}
