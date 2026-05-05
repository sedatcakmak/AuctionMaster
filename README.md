# AuctionMaster

A free auction-house plugin for Spigot/Paper. Originally created by
qKing12; continued by SedatTR (and rudde). Players list items for sale,
browse and bid on open auctions, and pick up their winnings or expired
listings.

## Features

- Buy-it-now and bidding auctions
- Auction expiry and item return
- Auction GUIs with categories and search
- Vault and PlayerPoints / TokenManager / CustomEconomy support
- PlaceholderAPI support
- Optional integrations: LiteBans, Citizens, ProtocolLib, HeadDatabase, Skript

## Requirements

- Spigot / Paper (built against API 1.13, recent dependency: spigot-api 1.21)
- Java 8 or newer
- Optional (soft dependencies): LiteBans, CustomEconomy, Citizens, Vault,
  PlayerPoints, TokenManager, PlaceholderAPI, Skript, ProtocolLib,
  HeadDatabase

## Commands

- `/auction` (aliases: `/ah`, `/auctions`, `/auctionhouse`, `/ahouse`) — open the auction menu
- `/ahview` — view a specific auction
- `/ahadmin` — admin tools

## Installation

1. Drop `AuctionMaster.jar` into your server's `plugins/` folder.
2. Start the server once to generate the default configuration.
3. Edit the files in `plugins/AuctionMaster/`, then reload or restart.

## Configuration

GUI layouts, auction settings (durations, taxes, limits), economy
selection and messages are all configured through the YAML files
generated under `plugins/AuctionMaster/`.

## Authors

- qKing12 (original author)
- SedatTR
- rudde

## License

See `LICENSE`.
